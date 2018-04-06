package com.kang.spring.aopxml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

public class LoggingAspect {

	
	public void beforMethod(JoinPoint joinpoint )
	{
		String methodName = joinpoint.getSignature().getName();
		Object[] args =joinpoint.getArgs();
		System.out.println("The method beforMethod " +methodName +","+ Arrays.asList(args));
	}
	
	public void afterMethod(JoinPoint joinPoint)
	{
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();

		System.out.println("The method afterMethod " +methodName +","+ Arrays.asList(args));
	}
	
	public void AfterReturning(JoinPoint joinPoint)
	{
		String methodName = joinPoint.getSignature().getName();
		Object [] args = joinPoint.getArgs();

		System.out.println("The method AfterReturning " +methodName +","+ Arrays.asList(args));
	}
	
	public void AfterThrowing(JoinPoint joinpoint)
	{
		String methodName = joinpoint.getSignature().getName();
		Object [] args = joinpoint.getArgs();

		System.out.println("The method AfterThrowing " +methodName +","+ Arrays.asList(args));
 	}
}
