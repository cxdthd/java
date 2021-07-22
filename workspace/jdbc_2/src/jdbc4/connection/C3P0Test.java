package jdbc4.connection;


import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

public class C3P0Test {

	//方式一：
	@Test
	public void testConnection() throws Exception{
		//获取c3p0数据库连接池
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass( "com.mysql.jdbc.Driver" ); //loads the jdbc driver            
		cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/test" );
		cpds.setUser("root");                                  
		cpds.setPassword("990618"); 
		
		//通过设置相关的参数，对数据库连接池进行管理；
		//设置初始时数据库连接池中的连接数
		cpds.setInitialPoolSize(10);
		
		Connection connection = cpds.getConnection();
		System.out.println(connection);
		
		//销毁c3p0数据库连接池 ---一般不会销毁
//		DataSources.destroy( cpds );
	}
	
	//方式二
	@Test
	public void testConnection1() throws Exception{
		ComboPooledDataSource cpds = new ComboPooledDataSource("yangc3p0");  //读取配置文件
		Connection connection = cpds.getConnection();
		System.out.println(connection);
	}
}
