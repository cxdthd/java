package jdbc5.blob;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.rowset.JdbcRowSet;

import org.hamcrest.core.Is;
import org.junit.Test;

import jdbc3.bean.Customer;
import util.JDBCUtils;

/**
 * 
* @Description 测试使用ProparedStatement操作Blob类型的数据
* @author cxdthd Email:1752713908@qq.com
* @version
* @date 2021年6月24日下午5:36:31
*
 */
public class BlobTest {
	
	//向数据表customers中插入Blob类型的字段
	@Test
	public void testInsert() throws Exception{
		Connection connection = JDBCUtils.getConnection();
		String sql = "insert into customers(name,email,birth,photo) values(?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setObject(1, "cc");
		ps.setObject(2, "cc@qq.com");
		ps.setObject(3, "1999-01-01");
		
		FileInputStream is = new FileInputStream(new File("cc.png"));

		ps.setBinaryStream(4, is );
		
		ps.execute();
		
		JDBCUtils.closeResource(connection, ps);
		is.close();
		
	}
	
	
	//查询数据表customers中Blob类型的字段
	@Test
	public void testQuery() throws Exception{
		Connection connection = JDBCUtils.getConnection();
		String sql = "select id,name,email,birth,photo from customers where id = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setObject(1, 16);
		InputStream is = null;
		FileOutputStream fs = null;
		
		ResultSet resultSet = ps.executeQuery();
		if(resultSet.next()){
			//方式一
//			int id = resultSet.getInt(1);
//			String name = resultSet.getString(2);
//			String email = resultSet.getString(3);
//			Date birth = resultSet.getDate(4);
			
			//方式二
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			String email = resultSet.getString("email");
			Date birth = resultSet.getDate("birth");
			
			Customer customer = new Customer(id, name, email, birth);
			System.out.println(customer);
			
			//将Blob类型的字段下载下来，以文件的方式保存在本地
			Blob photo = resultSet.getBlob("photo");
			is = photo.getBinaryStream();
			fs = new FileOutputStream("zy.jpg");
			byte[] buffer = new byte[1024];
			int len;
			while ((len = is.read(buffer)) != -1){
				fs.write(buffer, 0, len);
			}
			
		}
		
		JDBCUtils.closeResource(connection, ps, resultSet);
		is.close();
		fs.close();
		
	}
	
}
