package com.kang.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.jolbox.bonecp.BoneCPDataSource;

@Configuration
@ComponentScan(value="com.kang.springboot.config")
@PropertySource(value={"classpath:DataSource.properties"},ignoreResourceNotFound=false)
public class SpringConfig {
	
//	username:root
//	password:kang0622
//	jdbcUrl:jdbc:mysql:///runoob
//	driverClass:com.mysql.jdbc.Driver

	
	@Value("${jdbc.}")
	private String jdbcUrl;
	
	@Value("${jdbc.username}")
	private String username;
	
	@Value("${jdbc.password}")
	private String password;
	
	@Value("${jdbc.driverClass}")
	private String driverClass;
	
	@Bean
	public BoneCPDataSource  boneCPDataSource ()
	{
		BoneCPDataSource  boneCPDataSource  = new BoneCPDataSource ();
		
		boneCPDataSource.setJdbcUrl(jdbcUrl);
		boneCPDataSource.setUsername(username);
		boneCPDataSource.setDriverClass(driverClass);
		boneCPDataSource.setPassword(password);
		return boneCPDataSource ;
	}
	
	@Bean
	public UserDAO UserDAO()
	{
		return new UserDAO();
	}
	
	
//	@Bean
//	UserService userService()
//	{
//		return new UserService();
//	}
}
