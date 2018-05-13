package com.zhide.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.zhide.constStr.GlobalConst;
import com.zhide.entity.DisplayForm;
import com.zhide.entity.LoginCondition;
import com.zhide.entity.Role;
import com.zhide.entity.User;
import com.zhide.service.UserService;

@Controller
@RequestMapping("/UserController")
@SessionAttributes("displayForm")
public class LoginController {

	//调用业务层
	@Autowired
	UserService userServiceImpl;
	
	/*
	 *  验证登陆信息，成功登陆的情况下跳转至管理页面
	 * */
	@RequestMapping(value = "/doLogin")
	public String login(final Model model, LoginCondition loginCondition, HttpServletRequest request) {

		//檢查用戶的
		boolean result = userServiceImpl.checkUserExit(loginCondition);

		if (result) {
			//初始化頁面Form
			DisplayForm displayForm = new DisplayForm();
			
			//查詢用戶詳細信息
			User user= userServiceImpl.findUser(loginCondition.getLoginName());
			displayForm.setUserMessage(user);
			
			//給用戶請求添加令牌
			request.getSession().setAttribute(GlobalConst.USER_SESSION_KEY, loginCondition);
			
			//查詢所以用戶列表
			List<User> userList =  userServiceImpl.findAll();
			displayForm.setUserList(userList);
			
			//管理頁面初始化數據
			model.addAttribute("displayForm",displayForm);
			
			return "welcome/welcome";
			
		} else {
			return "Index";
		}
	}
	
	/*
	 *  登出操作
	 * */
	@RequestMapping("/loginOut")
	public String loginOut(HttpServletRequest request){
		//移除令牌
		request.getSession().removeAttribute(GlobalConst.USER_SESSION_KEY);
		return "Index";
	}
	/*
	 *  注册成功
	 * */
	@RequestMapping(value="/registerUser")
	public String registerUser(){
		return "Index";
	}
	
	/*
	 * 跳转至注册页面
	 * */
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String registerPage(){
		return "register";
	}
	
	/*
	 * 跳转至新增用户页面
	 * */
	@RequestMapping(value="/user/addUserPage")
	public String addUserPage(final Model model){
		//初始化用户
		User user = new User();
		model.addAttribute("user", user);
		
		//查询角色List	
		List<Role> userList = userServiceImpl.findAllRole();
		model.addAttribute("userList", userList);
		
		return "welcome/addUser";
	}
	/*
	 *  新增用户
	 * */
	@RequestMapping("/user/addUser")
	public String addUser(final Model model, @ModelAttribute("user") User user,HttpServletRequest request){
		userServiceImpl.insertUser(user);
		//初始化頁面Form
		DisplayForm displayForm = new DisplayForm();
		
		//查詢用戶詳細信息
		user= userServiceImpl.findUser(user.getLoginName());
		displayForm.setUserMessage(user);
		
		//查詢所以用戶列表
		List<User> userList =  userServiceImpl.findAll();
		displayForm.setUserList(userList);
		
		//管理頁面初始化數據
		model.addAttribute("displayForm",displayForm);
		return "welcome/welcome";
	}
	
	/*
	 * 删除用户
	 * */
	@RequestMapping("/user/deleteUser")
	public String deleteUser(final Model model, @ModelAttribute("displayForm") DisplayForm displayForm ){
		
		//删除对应的用户
		userServiceImpl.deleteUser(displayForm.getRow());
		
		//查詢所以用戶列表
		List<User> userList =  userServiceImpl.findAll();
		displayForm.setUserList(userList);
		
		//管理頁面初始化數據
		model.addAttribute("displayForm",displayForm);
		return "welcome/welcome";
	}
	
	/*
	 * 导出Excel
	 * */
	@RequestMapping(value="/user/exportExcel")
	public String exportExcel(){
		return "welcome/welcome";
	}
}
