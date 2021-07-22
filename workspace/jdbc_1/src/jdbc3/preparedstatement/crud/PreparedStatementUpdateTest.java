package jdbc3.preparedstatement.crud;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.junit.Test;

import util.JDBCUtils;

/*
 * 
 * 使用PreparedStatement来替代Statement,实现对数据表的增删改操作
 * 
 * 增删改；查
 * 
 */
public class PreparedStatementUpdateTest {
	
	@Test
	public void testCommonUpdate(){
//		String sql = "delete from customers where id = ?";
//		update(sql,3);
		
		//在sql里的关键字写在java的sql里也要加``号
		String sql = "update `order` set order_name = ? where order_id = ?";
		update(sql,"DD",2);
		
	}
	
	
	//通用的增删改操作
	public void update(String sql,Object ...args){//sql中占位符的个数与可变形参的长度一致
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//1.获取数据库的连接
			conn = JDBCUtils.getConnection();
			//2.预编译sql语句，返回PrepareStatement的实例
			ps = conn.prepareStatement(sql);
			//3.填充占位符
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i+1, args[i]);//小心参数声明错误！！
			}
			//4.执行
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//5.资源的关闭
			JDBCUtils.closeResource(conn, ps);
		}
		
	}
	
	
	//修改customers表的一条记录
	//这里应该改为try-catch-finally的，方便看步骤所有没改
	@Test
	public void testUpdate() throws Exception{
		
		//1.获取数据库连接
		Connection conn = JDBCUtils.getConnection();
		//2.预编译sql语句，返回PreparedStatement的实例
		String sql = "update customers set name = ? where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		//3.填充占位符
		ps.setObject(1, "莫扎特");
		ps.setObject(2, 18);
		//4.执行
		ps.execute();
		//5.资源的关闭
		JDBCUtils.closeResource(conn, ps);
		
	}
	
	
	//向customers表中添加一条数据
	@Test
	public void testInsert(){
		
		
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			//1.读取配置文件中的4个基本信息
			InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
			
			Properties pros = new Properties();
			pros.load(inputStream);
			
			String user = pros.getProperty("user");
			String password = pros.getProperty("password");
			String url = pros.getProperty("url");
			String driverClass = pros.getProperty("driverClass");
			
			//2.加载驱动
			Class.forName(driverClass);
			
			//3.获取连接
			connection = DriverManager.getConnection(url, user, password);
			
			//4.预编译sql语句，返回PreparedStatement的实例
//		String sql = "INSERT INTO customers VALUES(NULL,'Yang','175@qq.com','1999-06-14',NULL)";
			String sql = "insert into customers(name,email,birth) values(?,?,?)"; //?：占位符
			
			ps = connection.prepareStatement(sql);
			
			//5.填充占位符
			ps.setString(1, "哪吒");
			ps.setString(2, "nezha@gmail.com");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = sdf.parse("1000-01-01");
			ps.setDate(3, new Date(date.getTime()));
			
			//6.执行操作
			ps.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			//7.资源的关闭
			if (ps != null){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (connection != null){
				
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	

}
