package com.zhide.service;

import java.util.List;

import com.zhide.entity.LoginCondition;
import com.zhide.entity.Role;
import com.zhide.entity.User;

public interface UserService {

	//��C�Ñ��Ƿ���
	public boolean checkUserExit(LoginCondition loginCondition);
	
	//�Ñ�ע��
	public boolean insertUser(User user);
	
	//��ԃ�����Ñ�
	public List<User> findAll();
	
	//��ԃ�Ñ�Ԕ����Ϣ
	public User findUser(String userName);
	
	//��ѯ��ɫ��Ϣ
	public List<Role> findAllRole();
	
	//ɾ���û�
	public void deleteUser(String userID);
}
