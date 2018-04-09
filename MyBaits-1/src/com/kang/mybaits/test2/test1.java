package com.kang.mybaits.test2;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.kang.mybaits.Customer;
import com.kang.mybaits.Factory;

public class test1 {

	 SqlSessionFactory factory =  Factory.getSqlSessionFactory();

	
	@Test
	public void testAnnosation()
	{
		 SqlSession session = factory.openSession();
		 
		 CustomersMapper customersMapper =  session.getMapper(CustomersMapper.class);
		 customersMapper.updateCustomer(new Customer("liuxiaokang","xiao",200));
		 session.commit();
		 session.close();
	}
}
