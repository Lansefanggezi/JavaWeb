package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

//将类声明为Spring容器当中的bean，当调用时对该类实例化
@Controller
//声明Controller处理的请求 类级别
@RequestMapping("/Spring-MVC") 
public class HelloController {

	//方法级别的
	@RequestMapping("/pringWelcome")
	public String pringWelcome(ModelMap model)
	{
		model.addAttribute("message","HelloWorld");
		
		//返回hello交由ViewResolver
		return "/hello";
	}
}
