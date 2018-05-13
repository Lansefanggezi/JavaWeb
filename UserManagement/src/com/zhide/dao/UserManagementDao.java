package com.zhide.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhide.entity.LoginCondition;
import com.zhide.entity.Role;
import com.zhide.entity.User;

@Repository
public interface UserManagementDao {

	//��ѯ��������
	public Integer findPassword(LoginCondition loginCondition);
	
	//��ѯ�����û�
	public List<User> findAllUser();
	
	//�û�ע��
	public void insertUser(User user);
	
	//ɾ���û�
	public void delectUser(String id);
	
	//�Ñ�Ԕ����Ϣ
	public User findUserById(String id);
	
	//��ѯ���н�ɫ
	public List<Role> findAllRole();
	
	//�����û���Ϣ
	public void updateUser(User user);
}
