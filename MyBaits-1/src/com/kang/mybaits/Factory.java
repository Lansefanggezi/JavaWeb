package com.kang.mybaits;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Factory {

	public static SqlSessionFactory getSqlSessionFactory()
	{
		String name = "conf.xml";
		InputStream inputStream = CustomersTest.class.getClassLoader().getResourceAsStream(name);
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		
		return factory;
	}
}
