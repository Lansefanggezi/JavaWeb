package com.kang.spring.annotation.repository;

import org.springframework.stereotype.Repository;

@Repository("userJdbcRepository")
public class UserJdbcRepositoryImpl implements UserRepository {

	@Override
	public void save() {
		System.out.println("UserJdbcRepository");
	}

}
