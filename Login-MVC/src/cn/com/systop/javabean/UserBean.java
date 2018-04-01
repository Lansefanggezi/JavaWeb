package cn.com.systop.javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.com.systop.connection.DBConnection;

public class UserBean {

	//�û���
	private String userName;
	
	//����
	private String passWord;
	
	//�쳣
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
	 * ��֤��½
	 * 
	 * @return true ��½�ɹ� return flase ��½ʧ��
	 * 
	 * */
	public boolean login()
	{
		//��½�ɹ����ı�־
		boolean flg = false;
		
		//��ȡ���ݿ�����
		Connection con = DBConnection.getConnetction();
		
		//����PreparedStatement����
		PreparedStatement pstemt = null;
		
		//����resultSet
		ResultSet rs = null;
		
		//SQL���
		String sql = "select * from t_user where username = ?";
		
		
		try {
			//����PreparedStatement����
			pstemt = con.prepareStatement(sql);
			
			//�滻Sql����У���ֵ
			pstemt.setString(1, this.userName);
			
			//ִ��SQL��䲢���ؽ��
			rs = pstemt.executeQuery();
			
			//�жϽ�����Ƿ�������
			if(rs.next())
			{
				//�������
				String pwd = rs.getString("userpassword");
				
				//��֤����
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
				//�ر����ݿ�����
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