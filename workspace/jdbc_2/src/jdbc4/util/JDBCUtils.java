package jdbc4.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {

	/**
	 * 
	 * @Description 使用C3P0的数据库连接池技术
	 * @author cxdthd
	 * @date 2021年6月27日上午10:21:58
	 * @return
	 * @throws SQLException
	 */
	private static ComboPooledDataSource cpds = new ComboPooledDataSource("yangc3p0"); // 读取配置文件

	public static Connection getConnection1() throws SQLException {
		Connection connection = cpds.getConnection();
		return connection;
	}

	/**
	 * 
	 * @Description 使用DBCP的数据库连接池技术
	 * @author cxdthd
	 * @date 2021年6月27日上午11:13:17
	 * @return
	 * @throws Exception
	 */

	// 创建一个数据库连接池
	private static DataSource dataSource = null;

	static {
		try {
			Properties pros = new Properties();
			FileInputStream is = new FileInputStream("src/dbcp.properties");
			pros.load(is);
			dataSource = BasicDataSourceFactory.createDataSource(pros);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection2() throws Exception {

		Connection connection = dataSource.getConnection();
		return connection;
	}

	/**
	 * 
	 * @Description 使用druid的数据库连接池技术
	 * @author cxdthd
	 * @date 2021年6月28日下午5:03:18
	 * @return
	 */
	private static DataSource dataSource1 = null;
	static {
		try {
			Properties pros = new Properties();

			InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
			pros.load(is);

			dataSource1 = DruidDataSourceFactory.createDataSource(pros);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getDruidConnection() throws Exception {

		Connection connection = dataSource.getConnection();
		return connection;
	}

	// **********************************************************
	/**
	 * 
	 * @Description 获取数据库连接
	 * @author cxdthd
	 * @date 2021年6月18日下午11:00:13
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
		// 1.读取配置文件中的4个基本信息
		InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

		Properties props = new Properties();
		props.load(inputStream);

		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String url = props.getProperty("url");
		String driverClass = props.getProperty("driverClass");

		// 2.加载驱动
		Class.forName(driverClass);

		// 3.获取连接
		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;
	}

	/**
	 * 
	 * @Description 关闭连接和Statement的操作
	 * @author cxdthd
	 * @date 2021年6月18日下午11:42:40
	 * @param connection
	 * @param ps
	 */
	public static void closeResource(Connection connection, Statement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @Description 关闭资源的操作
	 * @author cxdthd
	 * @date 2021年6月19日下午4:26:34
	 * @param connection
	 * @param ps
	 * @param resultSet
	 */
	public static void closeResource(Connection connection, Statement ps, ResultSet resultSet) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	* @Description 使用dbutils.jar包中提供的DbUtils工具类，实现资源的关闭
	* @author cxdthd
	* @date 2021年6月28日下午8:33:47
	* @param connection
	* @param ps
	* @param resultSet
	 */
	public static void closeResourceDbutils(Connection connection, Statement ps, ResultSet resultSet) {
		//方式一：
//		try {
//			DbUtils.close(connection);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		try {
//			DbUtils.close(resultSet);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		try {
//			DbUtils.close(ps);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		//或：
		DbUtils.closeQuietly(connection);
		DbUtils.closeQuietly(ps);
		DbUtils.closeQuietly(resultSet);
	}
}
