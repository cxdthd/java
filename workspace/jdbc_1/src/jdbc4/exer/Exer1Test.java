package jdbc4.exer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import org.junit.Test;

import util.JDBCUtils;
//课后练习一
public class Exer1Test {

	
	@Test
	public void testInsert(){
		Scanner scanner = new Scanner(System.in);
		String sql = "insert into customers(id,name,email,birth) values(?,?,?,?)";
		System.out.print("请输入姓名：" );
		String name = scanner.next();
		System.out.print("请输入email：" );
		String email = scanner.next();
		System.out.print("请输入出生日期：" );
		String birth = scanner.next();	//这里有一个隐式转换，只要字符串写成“1999-01-01”的格式，也会转成日期格式
		int update = update(sql , null,name,email,birth);
		
		if (update >= 1){
			System.out.println("添加成功！！！");
		}else{
			System.out.println("添加失败！！！");
		}
	}
	
	
	//通用的增删改操作
	public int update(String sql,Object ...args){//sql中占位符的个数与可变形参的长度一致
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
			/*
			 * execute()
			 * 如果执行的是查询操作，有返回结果，则此方法返回true
			 * 如果执行的是增、删、改操作，没有返回结果，则此方法返回false
			 */
//			ps.execute();
			
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//5.资源的关闭
			JDBCUtils.closeResource(conn, ps);
		}
		return 0;
		
	}
}
