package jdbc1.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

public class ConnectionTest {

	//方式一
	@Test
	public void testConnection() throws SQLException {
		//获取Driver实现类对象
		Driver driver = new com.mysql.jdbc.Driver();
		
		//url:http://localhost/gmall/keyborad.jpg
		//jdbc:mysql:协议
		//localhost:ip地址
		//3306:默认mysql端口号
		//test:test数据库
		String url = "jdbc:mysql://localhost:3306/test";
		
		//将用户名和密码封装在Properties中
		Properties info = new Properties();
		info.setProperty("user", "root");
		info.setProperty("password", "990618");
		
		Connection conn = driver.connect(url,info);
		
		System.out.println(conn);
		
	}
	
	
	//方式二：是对方式一的迭代：在如下的程序中不出现第三方的api,使得程序具有更好的可移植性
	@Test
	public void testConnection1() throws Exception {
		//1.获取Driver实现类对象：使用反射
		Class clazz = Class.forName("com.mysql.jdbc.Driver");
		Driver driver = (Driver) clazz.newInstance();
		
		//2.提供要连接的数据库
		String url = "jdbc:mysql://localhost:3306/test";
		
		//3.提供连接需要的用户名和密码
		Properties info = new Properties();
		info.setProperty("user", "root");
		info.setProperty("password", "990618");
		
		//4。获取连接
		Connection conn = driver.connect(url, info);
		System.out.println(conn);
	}
	
	
	//方式三：使用DriverManager替代Driver
	@Test
	public void testConnection3() throws Exception{
		
		//1.获取Driver实现类的对象
		Class clazz = Class.forName("com.mysql.jdbc.Driver");
		Driver driver = (Driver) clazz.newInstance();
		
		//2.提供另外三个连接的基本信息
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "990618";
		
		//注册驱动
		DriverManager.registerDriver(driver);
		
		//获取连接
		Connection connection = DriverManager.getConnection(url, user, password);
		System.out.println(connection);
	}
	
	
	//方式四：对方式三的优化 --可以只是加载驱动，不用显示的注册驱动
	@Test
	public void testConnection4() throws Exception{
		
		//1.提供三个连接的基本信息
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "990618";
		
		//2.加载Driver
		Class.forName("com.mysql.jdbc.Driver");
		//相较于方式三，可以省略以下的操作：
//		Driver driver = (Driver) clazz.newInstance();
//		//注册驱动
//		DriverManager.registerDriver(driver);
		/*可以省略以上代码的原因是在mysql的Driver类里的静态代码块
		 * 
			static {
				try {
					java.sql.DriverManager.registerDriver(new Driver());
				} catch (SQLException E) {
					throw new RuntimeException("Can't register driver!");
				}
			}
 
		 */
		
		//获取连接
		Connection connection = DriverManager.getConnection(url, user, password);
		System.out.println(connection);
	}
	
	
	//方式五(final版)：将数据可以连接需要的4哥基本信息声明在配置文件中，通过读取配置文件的方式，获取连接
	/*
	 * 此种方式的好处：
	 * 1.实现了数据与代码的的分离。实现了解耦
	 * 2.如果需要修改配置文件信息，可以避免程序重新打包。
	 */
	@Test
	public void getConnection5() throws Exception{
		
		//1.读取配置文件中的4个基本信息
		InputStream inputStream = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
		
		Properties props = new Properties();
		props.load(inputStream);
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String url = props.getProperty("url");
		String driverClass = props.getProperty("driverClass");
		
		//2.加载驱动
		Class.forName(driverClass);
		
		//3.获取连接
		Connection connection = DriverManager.getConnection(url, user, password);
		System.out.println(connection);
		
		
	}
	
	
	
}
