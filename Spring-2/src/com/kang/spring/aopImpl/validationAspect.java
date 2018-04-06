package com.kang.spring.aopImpl;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class validationAspect {

	@Before(value="LoggingAspect.declareJoinPointExpression()")
	public void  validataion()
	{
		System.out.println("----->validation");
	}
}
