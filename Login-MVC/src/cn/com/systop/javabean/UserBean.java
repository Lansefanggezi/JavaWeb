package cn.com.systop.javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.com.systop.connection.DBConnection;

public class UserBean {

	//用户名
	private String userName;
	
	//密码
	private String passWord;
	
	//异常
	private String error;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	/*
	 * 验证登陆
	 * 
	 * @return true 登陆成功 return flase 登陆失败
	 * 
	 * */
	public boolean login()
	{
		//登陆成功与否的标志
		boolean flg = false;
		
		//获取数据库连接
		Connection con = DBConnection.getConnetction();
		
		//声明PreparedStatement对象
		PreparedStatement pstemt = null;
		
		//声明resultSet
		ResultSet rs = null;
		
		//SQL语句
		String sql = "select * from t_user where username = ?";
		
		
		try {
			//创建PreparedStatement对象
			pstemt = con.prepareStatement(sql);
			
			//替换Sql语句中？的值
			pstemt.setString(1, this.userName);
			
			//执行SQL语句并返回结果
			rs = pstemt.executeQuery();
			
			//判断结果集是否有数据
			if(rs.next())
			{
				//获得密码
				String pwd = rs.getString("userpassword");
				
				//验证密码
				if(this.passWord.equals(pwd))
				{
					flg=true;
				}else
				{
					this.setError("error");
				}
			}else
			{
				this.setError("error");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			try {
				//关闭数据库连接
				rs.close();
				pstemt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return flg;
	}
	
}
