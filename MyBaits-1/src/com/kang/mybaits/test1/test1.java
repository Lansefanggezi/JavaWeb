package com.kang.mybaits.test1;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.kang.mybaits.Customer;
import com.kang.mybaits.Factory;

public class test1 {

	 SqlSessionFactory factory =  Factory.getSqlSessionFactory();
	@Test
	public void testUpdate() {
		
		 SqlSession  session = factory.openSession();
		 
		 String statement = "com.kang.mybaits.test1.customerMapper.updateCus";
		 Customer customer = new Customer();
		 customer.setUsername("liuxiaokang");
		 customer.setBalance(500);
		 customer.setUserpassword("xiao");
		 session.update(statement,customer);
		 session.commit();
			session.close();
	}

	@Test
	public void testInsert()
	{
//		自动提交
		SqlSession session = factory.openSession(true);
		
		String statement = "com.kang.mybaits.test1.customerMapper.insertCus";
		Customer parameter = new Customer();
		parameter.setBalance(231);
		parameter.setUsername("jingdong");
		parameter.setUserpassword("1");
		session.insert(statement, parameter);
		session.close();
		
	}
	
	@Test
	public void testDelete()
	{
		//手动提交
		SqlSession session = factory.openSession();
		
		String statement = "com.kang.mybaits.test1.customerMapper.deleteCus";
		session.update(statement, "fan");
		session.commit();
		session.close();
	}
	
	@Test
	public  void testGetAll() 
	{
		SqlSession session = factory.openSession();
		String statement = "com.kang.mybaits.test1.customerMapper.selectAll";
		
		List<Customer> customers =  session.selectList(statement);
		System.out.println(customers);
	}
	
	@Test
	public void testAnnosation()
	{
		 SqlSession session = factory.openSession();
		 
		 CustomersMapper customersMapper =  session.getMapper(CustomersMapper.class);
		 customersMapper.updateCustomer(new Customer("liuxiaokang","xiao",200));
		 
	}
}
