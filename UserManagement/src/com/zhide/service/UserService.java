package com.zhide.service;

import java.util.List;

import com.zhide.entity.LoginCondition;
import com.zhide.entity.Role;
import com.zhide.entity.User;

public interface UserService {

	//驗證用戶是否登陸
	public boolean checkUserExit(LoginCondition loginCondition);
	
	//用戶注冊
	public boolean insertUser(User user);
	
	//查詢所有用戶
	public List<User> findAll();
	
	//查詢用戶詳細信息
	public User findUser(String userName);
	
	//查询角色信息
	public List<Role> findAllRole();
	
	//删除用户
	public void deleteUser(String userID);
}
