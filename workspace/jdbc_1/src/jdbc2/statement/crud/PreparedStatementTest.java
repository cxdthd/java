package jdbc2.statement.crud;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

import org.junit.Test;

import util.JDBCUtils;

/**
 * 
* @Description 演示使用PreparedStatement替代Statement,解决SQL注入问题
* @author cxdthd Email:1752713908@qq.com
* @version
* @date 2021年6月22日下午4:55:50
* 
* 除了解决Statement的拼串、sql问题之外，PreparedStatement还有哪些好处呢？
* 1.PreparedStatement可以操作Blob的数据，而Statement做不到
* 2.PreparedStatement可以实现更高效的批量操作。
*
 */
public class PreparedStatementTest {

	
	@Test
	public void testLogin() {
		Scanner scan = new Scanner(System.in);

		System.out.print("用户名：");
		String userName = scan.nextLine();
		System.out.print("密   码：");
		String password = scan.nextLine();

		String sql = "SELECT user,password FROM user_table WHERE USER = '1' or ' AND PASSWORD = '='1' or '1' = '1'";
		String sql2 = "SELECT user,password FROM user_table WHERE USER = ? and password = ?";
		User user = getInstance( User.class,sql,userName,password);
		if (user != null) {
			System.out.println("登陆成功!");
		} else {
			System.out.println("用户名或密码错误！");
		}
	}
	
	
	/**
	 * 
	* @Description 针对于不同的表的通用查询操作，返回表中的一条记录
	* @author cxdthd
	* @date 2021年6月22日下午4:22:54
	* @param clazz
	* @param sql
	* @param args
	* @return
	* 
	* 
	* 
	* 
	* 
	 */
	public <T> T getInstance(Class<T> clazz, String sql, Object ...args){
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			connection = JDBCUtils.getConnection();
			ps = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i+1, args[i]);
			}
			
			//执行，获取结果集
			resultSet = ps.executeQuery();
			//获取结果集的元数据
			ResultSetMetaData rsmd = resultSet.getMetaData();
			//获取列数
			int columnCount = rsmd.getColumnCount();
			
			if(resultSet.next()){
				T t = clazz.newInstance();
				for (int i = 0; i < columnCount; i++) {
					//获取每个列的列值：通过ResultSet
					Object columnValue = resultSet.getObject(i +1);
					//获取每个列的列名：通过ResultSetMetaData
					//获取列的列名：getColumnName() ---不推荐使用
					//获取列的别名：getColumnLabel() ---如果没有起别名那就默认列名
//				String columnName = rsmd.getColumnName(i+1);	//获取的是order_id
					String columnLabel = rsmd.getColumnLabel(i+1);	//获取的是orderId
					
					// 给t对象指定的columnLabel属性，赋值columnValue：通过反射
					Field field = clazz.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(t, columnValue);
					
				}
				
				return t;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//资源的关闭
			JDBCUtils.closeResource(connection, ps, resultSet);
		}
		return null;
		
	}

	
	
}
