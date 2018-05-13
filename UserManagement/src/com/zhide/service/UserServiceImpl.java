package com.zhide.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhide.dao.UserManagementDao;
import com.zhide.entity.LoginCondition;
import com.zhide.entity.Role;
import com.zhide.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserManagementDao userManagementDao;

	@Override
	public boolean checkUserExit(LoginCondition loginCondition) {

		// 查询用户是否存在
		int result = userManagementDao.findPassword(loginCondition);

		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean insertUser(User user) {
		//用戶信息插入
		userManagementDao.insertUser(user);
		
		return false;
	}

	@Override
	public List<User> findAll() {
		java.util.List<User> userList =userManagementDao.findAllUser();
		return userList;
	}

	@Override
	public User findUser(String userName) {
		User user = userManagementDao.findUserById(userName);
		return user;
	}

	@Override
	public List<Role> findAllRole() {
		//返回所有的角色
		return userManagementDao.findAllRole();
	}

	@Override
	public void deleteUser(String userID) {
		userManagementDao.delectUser(userID);
	}
}
