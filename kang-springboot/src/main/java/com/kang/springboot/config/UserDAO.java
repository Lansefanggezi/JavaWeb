package com.kang.springboot.config;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {

	public List getUserList()
	{
		List<User> userList = new ArrayList<User>();
		for(int i = 0; i<10; i++)
		{
			userList.add(new User("liuxiaokang","qwe"+i));
		}
		return userList;
	}
}
