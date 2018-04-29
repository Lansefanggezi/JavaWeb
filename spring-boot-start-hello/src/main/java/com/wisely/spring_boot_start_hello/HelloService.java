package com.wisely.spring_boot_start_hello;

public class HelloService {

	private String msg ;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String syaHello()
	{
		return "hello"+ this.msg;
	}
}
