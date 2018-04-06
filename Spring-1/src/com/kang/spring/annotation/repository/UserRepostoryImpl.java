package com.kang.spring.annotation.repository;

import org.springframework.stereotype.Repository;

@Repository("userRepostoryImpl")
public class UserRepostoryImpl implements UserRepository {

	@Override
	public void save() {
				System.out.println("UserRepostoryImpl");
	}

}
