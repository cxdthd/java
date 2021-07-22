package jdbc5.blob;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import util.JDBCUtils;

/*
 * 使用PreparedStatement实现批量数据的操作
 * 
 * update、delete本身就具有批量操作的效果
 * 此时的批量操作，主要指的是批量插入。使用PrepareStatement如何实现更高效的批量插入？
 * 
 * 
 * 题目：向goods表中插入20000条数据
 *  CREATE TABLE goods(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(25)
 * 
 * 
 */
public class InsertTest {
	
	//批量插入的方式一：使用Statement
	@Test
	public void testInsert() throws Exception{
		Connection connection = JDBCUtils.getConnection();
		Statement cs = connection.createStatement();
		long startTime = System.currentTimeMillis();
		for(int i = 1;i <= 20000;i++){
			String sql = "insert into goods(name) values ('name_" + i +"')";
			cs.execute(sql);
		}
		long stopTime = System.currentTimeMillis();
		System.out.println(stopTime - startTime);	//29367
		JDBCUtils.closeResource(connection, cs);
	}
	
	
	//批量插入的方式二：使用PreparedStatement
	@Test
	public void testInsert1() throws Exception{
		Connection connection = JDBCUtils.getConnection();
		String sql = "insert into goods(name) values(?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 20000; i++) {
			ps.setObject(1, "name_" + i);
			ps.execute();
		}
		long stopTime = System.currentTimeMillis();
		System.out.println(stopTime - startTime);	//25968
		JDBCUtils.closeResource(connection, ps);
	}

	
	/*
	 * 批量插入的方式三：
	 * 1.addBatch()、executeBatch()、clearBatch()
	 * 2.mysql服务器默认是关闭批处理的，我们需要通过一个参数，让mysql开启批处理的支持。
	 * 	 ?rewriteBatchedStatements=true 写在配置文件的url后面
	 */
	@Test
	public void testInsert2() throws Exception{
		Connection connection = JDBCUtils.getConnection();
		String sql = "insert into goods(name) values(?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		long startTime = System.currentTimeMillis();
		for (int i = 1; i <= 20000; i++) {
			ps.setObject(1, "name_" + i);
				
			//1."攒"sql
			ps.addBatch();
			
			if(i % 500 == 0){
				//2.执行batch
				ps.executeBatch();
				
				//3.清空batch
				ps.clearBatch();
			}
			
		}
		long stopTime = System.currentTimeMillis();
		System.out.println(stopTime - startTime);	//266
		JDBCUtils.closeResource(connection, ps);
	}
	
	
	//批量插入的方式四：
	@Test
	public void testInsert3() throws Exception{
		Connection connection = JDBCUtils.getConnection();
		
		//设置不允许自动提交数据
		connection.setAutoCommit(false);
		
		String sql = "insert into goods(name) values(?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		long startTime = System.currentTimeMillis();
		for (int i = 1; i <= 20000; i++) {
			ps.setObject(1, "name_" + i);
				
			//1."攒"sql
			ps.addBatch();
			
			if(i % 500 == 0){
				//2.执行batch
				ps.executeBatch();
				
				//3.清空batch
				ps.clearBatch();
			}
			
		}
		
		//提交数据
		connection.commit();
		
		long stopTime = System.currentTimeMillis();
		System.out.println(stopTime - startTime);	//200
		JDBCUtils.closeResource(connection, ps);
	}
	
}
