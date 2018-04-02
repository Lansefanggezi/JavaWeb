package com.systop.service.impl;

import com.systop.dao.UserDao;
import com.systop.model.User;
import com.systop.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	@Override
	public void add(User user) {
		userDao.save(user);
	}
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
