package com.systop.dao.impl;

import com.systop.dao.UserDao;
import com.systop.model.User;

public class UserDaoImpl implements UserDao {

	@Override
	public void save(User user) {
		System.out.println(user.getUserName() +"被存入数据库");				
	}

}
