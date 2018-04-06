package com.kang.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class AtithmeticCalculatorLoggingProxy {

	//要代理的对象
	private AtithmeticCalculator target;
	
	//构造器
	public AtithmeticCalculatorLoggingProxy(AtithmeticCalculator target)
	{
		this.target = target;
	}
	
	public AtithmeticCalculator getProxy()
	{
		AtithmeticCalculator proxy = null;
		
		
		//代理对象由哪儿一个类加载器负责加载
		ClassLoader loader =target.getClass().getClassLoader();
		
		//代理对象的类型，即其中有哪儿些方法
		Class [] interfaces = new Class[]{AtithmeticCalculator.class};
		
		//当调用代理对象其中的方法时，该执行的代码
		InvocationHandler invocationHandler = new InvocationHandler() {
			/**
			 * 
			 * */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				
				//获取方法名
				String methodName  = method.getName();
				
				//输出日志
				System.out.println("this method" + methodName + "begin with" + Arrays.asList(args));
				
				//执行方法
				Object result =  method.invoke(target, args);
				
				//日志
				System.out.println("this method" + methodName + "end with" + Arrays.asList(args));
				return result;
			}
		};
		proxy = (AtithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, invocationHandler);
		return proxy;
	}
}
