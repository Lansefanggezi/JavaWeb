package com.zhide.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhide.entity.LoginCondition;
import com.zhide.entity.Role;
import com.zhide.entity.User;

@Repository
public interface UserManagementDao {

	//查询密码密码
	public Integer findPassword(LoginCondition loginCondition);
	
	//查询所有用户
	public List<User> findAllUser();
	
	//用户注册
	public void insertUser(User user);
	
	//删除用户
	public void delectUser(String id);
	
	//用戶詳細信息
	public User findUserById(String id);
	
	//查询所有角色
	public List<Role> findAllRole();
	
	//更新用户信息
	public void updateUser(User user);
}
