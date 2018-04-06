package com.kang.spring.aopImpl;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component
public class LoggingAspect {

	@Pointcut(value="execution(* com.kang.spring.aopImpl.*.*(int,int))")
	public void declareJoinPointExpression()
	{}
	
	@Before(value = "declareJoinPointExpression()")
	public void beforMethod(JoinPoint joinpoint )
	{
		String methodName = joinpoint.getSignature().getName();
		Object[] args =joinpoint.getArgs();
		System.out.println("The method beforMethod " +methodName +","+ Arrays.asList(args));
	}
	
	@After(value="execution(* com.kang.spring.aopImpl.*.*(* , * ))")
	public void afterMethod(JoinPoint joinPoint)
	{
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();

		System.out.println("The method afterMethod " +methodName +","+ Arrays.asList(args));
	}
	
	@AfterReturning(value="execution(* com.kang.spring.aopImpl.*.*(int,int))")
	public void AfterReturning(JoinPoint joinPoint)
	{
		String methodName = joinPoint.getSignature().getName();
		Object [] args = joinPoint.getArgs();

		System.out.println("The method AfterReturning " +methodName +","+ Arrays.asList(args));
	}
	
	@AfterThrowing(value="execution(* com.kang.spring.aopImpl.*.*(int, int))")
	public void AfterThrowing(JoinPoint joinpoint)
	{
		String methodName = joinpoint.getSignature().getName();
		Object [] args = joinpoint.getArgs();

		System.out.println("The method AfterThrowing " +methodName +","+ Arrays.asList(args));
 	}
}
