package com.wisely.spring_boot_start_hello;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="hello")
public class HelloServiceProperties {

	//基于类型安全的属性获取，可以在application.properties中通过hello.msg=""设置，默认为world
	private static final String MSG = "world";
	private String msg = MSG;
	
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
