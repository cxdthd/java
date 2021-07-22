package jdbc3.preparedstatement.crud;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.junit.Test;

import jdbc3.bean.Order;
import util.JDBCUtils;

/**
 * 
* @Description 针对于Order表的通用的查询操作
* @author cxdthd Email:1752713908@qq.com
* @version
* @date 2021年6月20日下午8:38:32
*
 */
public class OrderForQuery {
	/*
	 * 针对于表的字段与类的属性名不相同的情况：
	 * 1. 必须在声明sql时，使用类的属性名来命名字段的别名
	 * 2. 使用ResultSetMetaData时，需要使用getColumnLabel()来替代getColumnName(),获取列的别名
	 * 	
	 * 	说明：如果sql中没有给字段起别名，getColumnLabel()获取的就是列名
	 * 
	 */
	
	@Test
	public void testOrderForQuery() throws Exception{
		String sql = "select order_id orderId,order_name orderName,order_date orderDate from `order` where order_id = ?";
		Order order = orderForQuery(sql , 1);
		System.out.println(order);
		
	}
	
	
	/**
	 * 
	* @Description 针对于order表的通用查询操作
	* @author cxdthd
	* @date 2021年6月20日下午9:07:27
	* @return
	 */
	public Order orderForQuery(String sql, Object ...args) throws Exception{
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
				Order order = new Order();
				for (int i = 0; i < columnCount; i++) {
					//获取每个列的列值：通过ResultSet
					Object columnValue = resultSet.getObject(i +1);
					//获取每个列的列名：通过ResultSetMetaData
					//获取列的列名：getColumnName() ---不推荐使用
					//获取列的别名：getColumnLabel() ---如果没有起别名那就默认列名
//				String columnName = rsmd.getColumnName(i+1);	//获取的是order_id
					String columnLabel = rsmd.getColumnLabel(i+1);	//获取的是orderId
					
					
					Field field = Order.class.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(order, columnValue);
					
				}
				
				return order;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//资源的关闭
			JDBCUtils.closeResource(connection, ps, resultSet);
		}
		return null;
		
	}
	
	
	
	
	@Test
	public void testQuery1() throws Exception{
		Connection connection = JDBCUtils.getConnection();
		
		String sql = "select order_id,order_name,order_date from `order` where order_id = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setObject(1, 1);
		
		ResultSet re = ps.executeQuery();
		
		if(re.next()){
			int orderId = re.getInt(1);
			String orderName = re.getString(2);
			Date orderDate = re.getDate(3);
			
			Order order = new Order(orderId, orderName, orderDate);
			System.out.println(order);
		}
		JDBCUtils.closeResource(connection, ps, re);
		
	}

}
