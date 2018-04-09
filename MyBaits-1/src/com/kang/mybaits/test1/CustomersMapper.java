package com.kang.mybaits.test1;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kang.mybaits.Customer;

public interface CustomersMapper {

	@Insert(value = { "insert into customers (username,userpassword,balance) values(#{username}, #{userpassword},#{balance})" })
	public int addCustomers(Customer customer);
	
	@Update("update customers set username = #{username} ,userpassword = #{userpassword}, balance = #{balance} where username = #{username}")
	public int updateCustomer(Customer customer);
	
	@Delete("delete from  customers where userpassword = #{userpassword}")
	public  int deleteCustomer(Customer customer);
	
	@Select("select * from customers")
	public List<Customer> selectAll();
}
