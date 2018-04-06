package com.kang.spring.aopImpl;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class validationAspect {

	@Before(value="execution(* com.kang.spring.aopImpl.*.*(int, int))")
	public void  validataion()
	{
		System.out.println("----->validation");
	}
}
