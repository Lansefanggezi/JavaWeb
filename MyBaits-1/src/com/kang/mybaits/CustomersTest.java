package com.kang.mybaits;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class CustomersTest {

	@Test
	public void test() {
		//��Դ����
		String name = "conf.xml";
		
		InputStream inputStream = CustomersTest.class.getClassLoader().getResourceAsStream(name);
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = factory.openSession();
		
		//mapper��namespace+selectId
		String stament = "com.kang.mybaits.customerMapper"+".getCustomer";
		Customer customer = session.selectOne(stament,"liuxiaokang");
		System.out.println(customer);
	}

}
