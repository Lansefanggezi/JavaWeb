package com.kang.spring.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kang.spring.annotation.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {


	private UserRepository userRepostoryImpl;
	
	@Override
	public boolean save() {
		System.out.println("UserServiceImpl");
		userRepostoryImpl.save();
		return false;
	}

	public UserRepository getUserRepostory() {
		return userRepostoryImpl;
	}
	@Autowired()
	@Qualifier("userJdbcRepository")
	public void setUserRepostoryImpl(UserRepository userRepostoryImpl) {
		this.userRepostoryImpl = userRepostoryImpl;
	}
	
	
}
