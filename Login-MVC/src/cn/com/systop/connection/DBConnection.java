package cn.com.systop.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * 
 * �������ݿ�
 * @author Admin
 * 
 * */
public class DBConnection {
	
	//�������ݿ����õ��ַ���
	private static final String URL = "jdbc:mysql://localhost:3306/RUNOOB";
	
	//���ݿ��½�û���
	private final static String USERNAME = "root";
	
	//��½����
	private final static String PASSWORD ="kang0622";
	
	/*
	 * ��ȡ���ݿ�����
	 * 
	 * */
	public static Connection getConnetction(){
		
		Connection con = null;
		
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			
			//������ݿ�����
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