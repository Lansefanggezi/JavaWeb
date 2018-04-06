package com.kang.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class AtithmeticCalculatorLoggingProxy {

	//Ҫ����Ķ���
	private AtithmeticCalculator target;
	
	//������
	public AtithmeticCalculatorLoggingProxy(AtithmeticCalculator target)
	{
		this.target = target;
	}
	
	public AtithmeticCalculator getProxy()
	{
		AtithmeticCalculator proxy = null;
		
		
		//����������Ķ�һ����������������
		ClassLoader loader =target.getClass().getClassLoader();
		
		//�����������ͣ����������Ķ�Щ����
		Class [] interfaces = new Class[]{AtithmeticCalculator.class};
		
		//�����ô���������еķ���ʱ����ִ�еĴ���
		InvocationHandler invocationHandler = new InvocationHandler() {
			/**
			 * 
			 * */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				
				//��ȡ������
				String methodName  = method.getName();
				
				//�����־
				System.out.println("this method" + methodName + "begin with" + Arrays.asList(args));
				
				//ִ�з���
				Object result =  method.invoke(target, args);
				
				//��־
				System.out.println("this method" + methodName + "end with" + Arrays.asList(args));
				return result;
			}
		};
		proxy = (AtithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, invocationHandler);
		return proxy;
	}
}
