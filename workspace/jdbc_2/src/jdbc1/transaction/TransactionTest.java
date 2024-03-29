package jdbc1.transaction;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.junit.Test;

import jdbc0.util.JDBCUtils;
/*
 * 事务：一组逻辑操作单元，使数据从一种状态变换到另一种状态
 * 		> 一组逻辑操作单元：一个或多个DML操作
 * 
 * 哪些操作会导致数据的自动提交？
 * 		>DDL操作一旦执行，都会自动提交
 * 			> set autocommit = false 对DDL操作失效
 * 		>DML默认情况下，一旦执行，就会自动提交
 * 			>我们可以通过set autocommit false的方式取消DML操作的自动提交
 * 		>默认在关闭连接时，会自动的提交数据
 * 
 */

public class TransactionTest {

	// *********************************未考虑数据库事务情况下的转账操作********************************************
	/*
	 * 针对于数据表user_table来说： AA用户给BB用户转账100
	 * 
	 * update user_table set balance = balance - 100 where user = 'AA' update
	 * user_table set balance = balance + 100 where user = 'BB'
	 * 
	 */
	@Test
	public void testUpdate() {

		String sql1 = "update user_table set balance = balance - 100 where user =?";
		update(sql1, "AA");

		// 模拟网络异常
		System.out.println(10 / 0);

		String sql2 = "update user_table set balance = balance + 100 where user =?";
		update(sql2, "BB");

		System.out.println("转账成功！");
	}

	// 通用的增删改操作 -----version 1.0
	public int update(String sql, Object... args) {// sql中占位符的个数与可变形参的长度一致
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			// 1.获取数据库的连接
			conn = JDBCUtils.getConnection();
			// 2.预编译sql语句，返回PrepareStatement的实例
			ps = conn.prepareStatement(sql);
			// 3.填充占位符
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);// 小心参数声明错误！！
			}
			// 4.执行
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5.资源的关闭
			JDBCUtils.closeResource(conn, ps);
		}
		return 0;

	}

	// ***********************************考虑数据库事务后的转账操作******************************************

	@Test
	public void testUpdateWithTx() {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();

			System.out.println(conn.getAutoCommit()); // true
			// 1.取消数据的自动提交
			conn.setAutoCommit(false);

			String sql1 = "update user_table set balance = balance - 100 where user =?";
			update(conn, sql1, "AA");

			// 模拟网络异常
			System.out.println(10 / 0);

			String sql2 = "update user_table set balance = balance + 100 where user =?";
			update(conn, sql2, "BB");

			System.out.println("转账成功！");

			// 2.提交数据
			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
			// 3.回滚数据
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {

			// 修改其为自动提交数据 ---> 主要针对于使用数据库连接池的使用
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			JDBCUtils.closeResource(conn, null);
		}
	}

	// 通用的增删改操作 -----version 2.0 （考虑数据库事务）
	public int update(Connection conn, String sql, Object... args) {// sql中占位符的个数与可变形参的长度一致
		PreparedStatement ps = null;
		try {
			// 1.预编译sql语句，返回PrepareStatement的实例
			ps = conn.prepareStatement(sql);
			// 2.填充占位符
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);// 小心参数声明错误！！
			}
			// 3.执行
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4.资源的关闭
			JDBCUtils.closeResource(null, ps);
		}
		return 0;

	}

	// *********************************************************************************

	@Test
	public void testTransactionSelect() throws Exception{
		Connection connection = JDBCUtils.getConnection();
		
		//获取当前连接的隔离级别
		System.out.println(connection.getTransactionIsolation());
		
		//设置数据库的隔离级别
		connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
		
		//取消自动提交数据
		connection.setAutoCommit(false);
		
		String sql = "select user,password,balance from user_table where user =?";
		User user = getInstance(connection,User.class,sql ,"CC");
		System.out.println(user);
	}
	
	@Test
	public void testTransactionUpdate() throws Exception{
		Connection connection = JDBCUtils.getConnection();
		
		//取消自动提交数据
		connection.setAutoCommit(false);
		
		String sql = "update user_table set balance = ? where user = ?";
		update(connection,sql,4000,"CC");
		
		Thread.sleep(15000);
		System.out.println("修改结束");
	}
	
	
	//通用的查询操作，用于返回数据表中的一条记录（version 2.0：考虑上事务）
	public <T> T getInstance(Connection conn,Class<T> clazz, String sql, Object... args) {
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}

			// 执行，获取结果集
			resultSet = ps.executeQuery();
			// 获取结果集的元数据
			ResultSetMetaData rsmd = resultSet.getMetaData();
			// 获取列数
			int columnCount = rsmd.getColumnCount();

			if (resultSet.next()) {
				T t = clazz.newInstance();
				for (int i = 0; i < columnCount; i++) {
					// 获取每个列的列值：通过ResultSet
					Object columnValue = resultSet.getObject(i + 1);
					// 获取每个列的列名：通过ResultSetMetaData
					// 获取列的列名：getColumnName() ---不推荐使用
					// 获取列的别名：getColumnLabel() ---如果没有起别名那就默认列名
					// String columnName = rsmd.getColumnName(i+1);
					// //获取的是order_id
					String columnLabel = rsmd.getColumnLabel(i + 1); // 获取的是orderId

					// 给t对象指定的columnLabel属性，赋值columnValue：通过反射
					Field field = clazz.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(t, columnValue);

				}

				return t;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 资源的关闭
			JDBCUtils.closeResource(null, ps, resultSet);
		}
		return null;

	}

}
