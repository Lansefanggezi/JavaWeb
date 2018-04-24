package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

//��������ΪSpring�������е�bean��������ʱ�Ը���ʵ����
@Controller
//����Controller���������� �༶��
@RequestMapping("/Spring-MVC") 
public class BookShopController {

	//���������
	@RequestMapping("/pringWelcome")
	public String pringWelcome(ModelMap model)
	{
		model.addAttribute("message","HelloWorld");
		
		//����hello����ViewResolver
		return "/hello";
	}
}