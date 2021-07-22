package jdbc3.preparedstatement.crud;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.junit.Test;

import jdbc3.bean.Customer;
import util.JDBCUtils;

/**
 * 
* @Description 针对于Customers表的查询操作
* @author cxdthd Email:1752713908@qq.com
* @version
* @date 2021年6月19日下午2:29:26
*
 */
public class CustomerForQuery{
	
	@Test
	public void testQueryForCustomers() throws Exception{
		String sql = "select id,name,birth from customers where id = ?";
		Customer customer = queryForCustomers(sql, 7);
		System.out.println(customer);
	}
	
	/**
	 * 
	* @Description 针对于customers表的通用查询操作
	* @author cxdthd
	* @date 2021年6月19日下午4:31:24
	 */
	public Customer queryForCustomers(String sql,Object ...args) throws Exception{
		//1.获取连接
		Connection connection = JDBCUtils.getConnection();
		//2.获取PreparedStatement的实例 (或：预编译sql语句)
		PreparedStatement ps = connection.prepareStatement(sql);
		//3.填充占位符
		for (int i = 0; i < args.length; i++) {
			ps.setObject(i+1, args[i]);
		}
		//4.执行executeQuery(),得到结果集：ResultSet
		ResultSet rs = ps.executeQuery();
		//获取结果集的元数据：ResultSetMetaData
		ResultSetMetaData rsmd = rs.getMetaData();
		//通过ResultSetMetaData获取结果集的列数
		int columnCount = rsmd.getColumnCount();
		
		if (rs.next()){
			Customer cust = new Customer();
			//处理结果集一行数据中的每一个列
			for(int i = 0;i < columnCount;i++){
				//获取列值
				Object columnValue = rs.getObject(i + 1);
				
				//获取每个列的列名
				String columnName = rsmd.getColumnName(i + 1);
				
				//给cust对象指定的columnName属性，赋值为columnValue:通过反射
				Field field = Customer.class.getDeclaredField(columnName);
				field.setAccessible(true);
				field.set(cust, columnValue);
			}
			return cust;
		}
		
		//5.资源的关闭
		JDBCUtils.closeResource(connection, ps, rs);
		
		return null;
	}
	
	
	@Test
	public void testQuery1() throws Exception{
		Connection conn = JDBCUtils.getConnection();
		String sql = "select id,name,email,birth from customers where id = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setObject(1, 1);
		
		//执行,并返回结果集
		ResultSet resultSet = ps.executeQuery();
		//处理结果集
		if (resultSet.next()) { //next():判断结果集的下一条是否有数据，如果有数据返回true，并指针下移；如果返回false，指针不会下移
			
			//获取当前这条数据的各个字段名
			int id = resultSet.getInt(1);
			String name = resultSet.getString(2);
			String email = resultSet.getString(3);
			Date birth = resultSet.getDate(4);
			
			//方式一
//			System.out.println("id = " + id + ",name = " + name + ",email = " + ",birth = " + birth);
			//方式二
//			Object[] data = new Object[]{id,name,email,birth};
			//方式三：将数据封装为一个对象（推荐）
			Customer customer = new Customer(id, name, email, birth);
			System.out.println(customer);
		}
		
		//资源的关闭
		JDBCUtils.closeResource(conn, ps, resultSet);
		
	}

}
