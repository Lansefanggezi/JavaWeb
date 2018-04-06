package com.kang.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class AtithmeticCalculatorLoggingImpl implements AtithmeticCalculator {

	@Override
	public int add(int i, int j) {
		System.out.println("AtithmeticCalculatorImpl add begin[" + i +","+ j +"]");
		int result = i +j;
		System.out.println("AtithmeticCalculatorImpl add end[" + i +","+ j +"]");
		return result;
	}

	@Override
	public int sub(int i, int j) {
		System.out.println("AtithmeticCalculatorImpl sub begin[" + i +","+ j +"]");
		int result = i - j;
		System.out.println("AtithmeticCalculatorImpl sub end[" + i +","+ j +"]");
		return result;
	}

	@Override
	public int mul(int i, int j) {
		System.out.println("AtithmeticCalculatorImpl mul begin[" + i +","+ j +"]");
		int result = i * j;
		System.out.println("AtithmeticCalculatorImpl mul end[" + i +","+ j +"]");
		return result;
	}

	@Override
	public int div(int i, int j) {
		System.out.println("AtithmeticCalculatorImpl div begin[" + i +","+ j +"]");
		int result = i / j;
		System.out.println("AtithmeticCalculatorImpl div end[" + i +","+ j +"]");
		return result;
	}

}
