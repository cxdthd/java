package jdbc4.connection;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

public class DBCPTest {
	/**
	 * 
	* @Description 测试DBCP的数据库连接池技术
	* @author cxdthd
	* @date 2021年6月27日上午10:45:37
	* @throws SQLException
	 */
	//方式一：不推荐
	@Test
	public void testGetConnection() throws SQLException{
		//创建了DBCP的数据库连接池
		BasicDataSource source = new BasicDataSource();
		
		//设置基本信息
		source.setDriverClassName("com.mysql.jdbc.Driver");
		source.setUrl("jdbc:mysql:///test");
		source.setUsername("root");
		source.setPassword("990618");
		
		//还可以设置其他涉及数据库连接池管理的相关属性：
		source.setInitialSize(10);
		source.setMaxActive(10);
		
		Connection connection = source.getConnection();
		System.out.println(connection);
	}
	
	
	//方式二：使用配置文件(推荐)
	@Test
	public void testGetConnection1() throws Exception{
		
		Properties pros  = new Properties();
		
		//方式一：使用类的加载器
//		InputStream is = ClassLoader.getSystemClassLoader().getSystemResourceAsStream("dbcp.properties");
		
		//方式二：使用文件流
		FileInputStream is = new FileInputStream("src/dbcp.properties");
		
		
		pros.load(is);
		DataSource dataSource = BasicDataSourceFactory.createDataSource(pros);
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
	}

}
