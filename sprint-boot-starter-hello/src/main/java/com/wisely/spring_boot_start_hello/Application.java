package com.wisely.spring_boot_start_hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Application {

	@Autowired
	HelloService helloService;
	
	@RequestMapping("/")
	public String index()
	{
		return helloService.syaHello();
	}
	
	public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
	}
}
