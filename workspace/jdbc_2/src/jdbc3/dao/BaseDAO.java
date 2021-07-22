package jdbc3.dao;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import jdbc4.util.JDBCUtils;

/*
 * DAO: data(base) access object
 * 封装了针对于数据表的通用操作
 * 
 */
public abstract class BaseDAO<T> {
	
	private QueryRunner runner = new QueryRunner();

	private Class<T> clazz = null;

	// public BaseDAO(){
	//
	// }

	{
		// 获取当前BaseDAO的子类继承父类中的泛型
		Type genericSuperclass = this.getClass().getGenericSuperclass();
		ParameterizedType paramType = (ParameterizedType) genericSuperclass;
		Type[] typeArguments = paramType.getActualTypeArguments();
		clazz = (Class<T>) typeArguments[0];
	}

	// 通用的增删改操作 -----version 2.0 （考虑数据库事务）
	public int update(Connection conn, String sql, Object... args) {// sql中占位符的个数与可变形参的长度一致
		// PreparedStatement ps = null;
		// try {
		// // 1.预编译sql语句，返回PrepareStatement的实例
		// ps = conn.prepareStatement(sql);
		// // 2.填充占位符
		// for (int i = 0; i < args.length; i++) {
		// ps.setObject(i + 1, args[i]);// 小心参数声明错误！！
		// }
		// // 3.执行
		// return ps.executeUpdate();
		// } catch (Exception e) {
		// e.printStackTrace();
		// } finally {
		// // 4.资源的关闭
		// JDBCUtils.closeResource(null, ps);
		// }
		// return 0;
		int i = 0;
		try {
			i = runner.update(conn, sql, args);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, null);
		}
		return i;

	}

	// 通用的查询操作，用于返回数据表中的一条记录（version 2.0：考虑上事务）
	public T getInstance(Connection conn, String sql, Object... args) {
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

	// 通用的查询操作，用于返回数据表中的多条记录（version 2.0：考虑上事务）
	public List<T> getForList(Connection connection, String sql, Object... args){
		
		List<T> list = null;
		try {
			BeanListHandler<T> handler = new BeanListHandler<T>(clazz);
			list = runner.query(connection, sql, handler, args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
		
		
//		PreparedStatement ps = null;
//		ResultSet resultSet = null;
//		try {
//			ps = connection.prepareStatement(sql);
//			for (int i = 0; i < args.length; i++) {
//				ps.setObject(i + 1, args[i]);
//			}
//
//			// 执行，获取结果集
//			resultSet = ps.executeQuery();
//			// 获取结果集的元数据
//			ResultSetMetaData rsmd = resultSet.getMetaData();
//			// 获取列数
//			int columnCount = rsmd.getColumnCount();
//
//			// 创建集和对象
//			List<T> list = new ArrayList<T>();
//
//			while (resultSet.next()) {
//
//				T t = clazz.newInstance();
//				// 处理结果集一行数据中的每一个列：给t对象指定的属性赋值
//				for (int i = 0; i < columnCount; i++) {
//					// 获取每个列的列值：通过ResultSet
//					Object columnValue = resultSet.getObject(i + 1);
//					// 获取每个列的列名：通过ResultSetMetaData
//					// 获取列的列名：getColumnName() ---不推荐使用
//					// 获取列的别名：getColumnLabel() ---如果没有起别名那就默认列名
//					// String columnName = rsmd.getColumnName(i+1);
//					// //获取的是order_id
//					String columnLabel = rsmd.getColumnLabel(i + 1); // 获取的是orderId
//
//					// 给t对象指定的columnLabel属性，赋值columnValue：通过反射
//					Field field = clazz.getDeclaredField(columnLabel);
//					field.setAccessible(true);
//					field.set(t, columnValue);
//
//				}
//				list.add(t);
//
//			}
//			return list;
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			// 资源的关闭
//			JDBCUtils.closeResource(null, ps, resultSet);
//		}
//		return null;

	}

	// 用于查询特殊值的通用方法
	public <E> E getValue(Connection connection, String sql, Object... args) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}

			rs = ps.executeQuery();
			if (rs.next()) {
				return (E) rs.getObject(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			JDBCUtils.closeResource(connection, ps, rs);
		}
		return null;
	}

}
