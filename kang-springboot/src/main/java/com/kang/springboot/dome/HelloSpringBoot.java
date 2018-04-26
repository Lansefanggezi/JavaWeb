package com.kang.springboot.dome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication(exclude={RedisAutoConfiguration.class})
@Controller
@Configuration
public class HelloSpringBoot {

	@ResponseBody
	@RequestMapping("/hello")
	public String index()
	{
		return "Hello World";
	}
	public static void main(String[] args)
	{
		SpringApplication application = new SpringApplication(HelloSpringBoot.class);
		application.run(args);
	}
}
