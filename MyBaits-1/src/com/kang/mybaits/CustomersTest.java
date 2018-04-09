package com.kang.mybaits;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class CustomersTest {

	@Test
	public void test() {
		//资源名称
		String name = "conf.xml";
		
		InputStream inputStream = CustomersTest.class.getClassLoader().getResourceAsStream(name);
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = factory.openSession(true);
		
		//mapper的namespace+selectId
//		String stamentSelect = "com.kang.mybaits.customerMapper"+".getCustomer";
//		Customer customer = session.selectOne(stamentSelect,"liuxiaokang");
		
		//更新
		String stamentUpdate = "com.kang.mybaits.customerMapper"+".getCustomer";
		Customer customerUp = new Customer();
		customerUp.setUsername("liuxiaokang");
		customerUp.setUserpassword("xiao");
		customerUp.setBalance(500);
		session.update(stamentUpdate, customerUp);
		session.commit();
		
//		//删除
//		String stamentSelect = "com.kang.mybaits.customerMapper"+".getCustomer";
//		Customer customer = session.selectOne(stamentSelect,"liuxiaokang");
//		//插入
//		String stamentSelect = "com.kang.mybaits.customerMapper"+".getCustomer";
//		Customer customer = session.selectOne(stamentSelect,"liuxiaokang");
		System.out.println(customerUp);
	}

	/**
	 * 使用resutlMap
	 * */
	public void testCustomer2()
	{
		String name = "conf.xml";
		InputStream inputStream=
				CustomersTest.class.getClassLoader().getResourceAsStream(name);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = factory.openSession();
//		指向映射文件中的sql文
		String statement = "com.kang.mybaits.customerMapper.";
		session.selectOne(statement);
		
	}
	
}
