package cn.com.systop.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * 
 * 连接数据库
 * @author Admin
 * 
 * */
public class DBConnection {
	
	//连接数据库所用的字符串
	private static final String URL = "jdbc:mysql://localhost:3306/RUNOOB";
	
	//数据库登陆用户名
	private final static String USERNAME = "root";
	
	//登陆密码
	private final static String PASSWORD ="kang0622";
	
	/*
	 * 获取数据库连接
	 * 
	 * */
	public static Connection getConnetction(){
		
		Connection con = null;
		
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//获得数据库连接
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
		
	}
}
