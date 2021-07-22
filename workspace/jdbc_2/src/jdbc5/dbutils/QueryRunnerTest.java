package jdbc5.dbutils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import jdbc2.bean.Customer;
import jdbc4.util.JDBCUtils;

public class QueryRunnerTest {
	
	//测试插入
	@Test
	public void testInsert(){
		Connection connection = null;
		try {
			QueryRunner runner = new QueryRunner();
			connection = JDBCUtils.getDruidConnection();
			String sql = "insert into customers(name,email,birth)values(?,?,?)";
			int update = runner.update(connection, sql, "llxcc","llxcc@qq.com","1999-07-07");
			if(update >0){
				System.out.println("添加成功！");
			}else{
				System.out.println("添加失败！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			JDBCUtils.closeResource(connection, null);
		}
		
	}
	
	//测试查询
	/*
	 * BeanHander：是ResultSetHandler接口的实现类，用于封装表中的一条记录
	 */
	@Test
	public void testQuery(){
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getDruidConnection();
			String sql = "select id,name,email,birth from customers where id = ?";
			//结果集的处理器
			BeanHandler<Customer> handler = new BeanHandler<Customer>(Customer.class);
			Customer customer = runner.query(conn, sql, handler, "12");
			System.out.println(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null);
		}
	}
	/*
	 * BeanListHandler：是ResultSetHandler接口的实现类，用于封装表中的多条记录构成的集和。
	 */
	@Test
	public void testQuery1(){
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getDruidConnection();
			String sql = "select id,name,email,birth from customers where id < ?";
			//结果集的处理器
			BeanListHandler<Customer> handler = new BeanListHandler<Customer>(Customer.class);
			List<Customer> list = runner.query(conn, sql, handler, "23");
			list.forEach(System.out :: println);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null);
		}
	}
	/*
	 * MapHander：是ResultSetHandler接口的实现类，对应表中的一条记录
	 * 将字段及相对应的值作为map中的key和value
	 */
	@Test
	public void testQuery2(){
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getDruidConnection();
			String sql = "select id,name,email,birth from customers where id = ?";
			//结果集的处理器
			MapHandler handler = new MapHandler();
			Map<String, Object> map = runner.query(conn, sql, handler, "12");
			System.out.println(map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null);
		}
	}
	/*
	 * MapListHander：是ResultSetHandler接口的实现类，对应表中的多条记录
	 * 将字段及相对应的值作为map中的key和value，将这些map添加到List中
	 */
	@Test
	public void testQuery3(){
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getDruidConnection();
			String sql = "select id,name,email,birth from customers where id < ?";
			//结果集的处理器
			MapListHandler handler = new MapListHandler();
			List<Map<String, Object>> map = runner.query(conn, sql, handler, "22");
			map.forEach(System.out :: println);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null);
		}
	}
	
	/*
	 * ScalarHandler：用于查询特殊值
	 */
	@Test
	public void testQuery4(){
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getDruidConnection();
			String sql = "select count(*) from customers";
			//结果集的处理器
			ScalarHandler handler = new ScalarHandler();
			Long count = (Long) runner.query(conn, sql, handler);
			System.out.println(count);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null);
		}
	}
	
	@Test
	public void testQuery5(){
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getDruidConnection();
			String sql = "select max(birth) from customers";
			//结果集的处理器
			ScalarHandler handler = new ScalarHandler();
			Date date = (Date) runner.query(conn, sql, handler);
			System.out.println(date);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null);
		}
	}
	/*
	 * 自定义
	 */
	@Test
	public void testQuery6(){
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getDruidConnection();
			String sql = "select id,name,email,birth from customers where id = ?";
			//结果集的处理器
			ResultSetHandler<Customer> handler = new ResultSetHandler<Customer>(){

				@Override
				public Customer handle(ResultSet rs) throws SQLException {

					if(rs.next()){
						int id = rs.getInt("id");
						String name = rs.getString("name");
						String email = rs.getString("email");
						java.sql.Date birth = rs.getDate("birth");
						Customer customer = new Customer(id, name, email, birth);
						return customer;
					}
					return null;
				}};
			Customer customer = runner.query(conn, sql, handler,12);
			System.out.println(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null);
		}
	}

}






