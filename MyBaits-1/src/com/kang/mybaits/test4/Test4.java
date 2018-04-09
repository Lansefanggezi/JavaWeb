package com.kang.mybaits.test4;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.kang.mybaits.Factory;
import com.kang.mybaits.bean.Classes;

public class Test4 {

	SqlSessionFactory factory = Factory.getSqlSessionFactory();
	
	@Test
	public void test() {
		SqlSession session = factory.openSession();
		
		String statement =  "com.kang.mybaits.test4.MyBaits.getClases2";
		List<Classes> classes = session.selectList(statement,1);
		System.out.println(classes);
		session.commit();
		session.close();
	}

}
