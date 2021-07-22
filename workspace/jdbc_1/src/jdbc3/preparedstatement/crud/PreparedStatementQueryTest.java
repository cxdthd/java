package jdbc3.preparedstatement.crud;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import jdbc3.bean.Customer;
import jdbc3.bean.Order;
import util.JDBCUtils;

/**
 * 
* @Description 使用PreparedStatement实现针对于不同表的通用的查询操作
* @author cxdthd Email:1752713908@qq.com
* @version
* @date 2021年6月22日下午3:46:48
*
 */
public class PreparedStatementQueryTest {
	
	
	
	@Test
	public void testGetForList(){
		String sql = "select id,name,email,birth from customers where id < ? ";
		List<Customer> list = getForList(Customer.class,sql ,12);
		
//		Iterator<Customer> iterator = list.iterator();
//		while (iterator.hasNext()){
//			System.out.println(iterator.next());
//		}
		list.forEach(System.out :: println);
		
		
		String sql2 = "select order_id orderId,order_name orderName,order_date orderDate from `order`";
		List<Order> list2 = getForList(Order.class, sql2);
		list2.forEach(System.out::println);
		
	}
	
	
	public <T> List<T> getForList(Class<T> clazz, String sql, Object ...args){
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
			
			//创建集和对象
			List<T> list = new ArrayList<T>();
			
			while (resultSet.next()){
				
				
				T t = clazz.newInstance();
				// 处理结果集一行数据中的每一个列：给t对象指定的属性赋值
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
				list.add(t);
				
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//资源的关闭
			JDBCUtils.closeResource(connection, ps, resultSet);
		}
		return null;
		
		
	}
	
	
	
	@Test
	public void testGetInstance(){
		String sql = "select id,name,email,birth from customers where id = ?";
		Customer customer = getInstance(Customer.class,sql,12 );
		System.out.println(customer);
		
		String sql2 = "select order_id orderId,order_name orderName,order_date orderDate from `order` where order_id = ?";
		Order order = getInstance(Order.class, sql2, 2);
		System.out.println(order);
		
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
