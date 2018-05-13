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

	//����ҵ���
	@Autowired
	UserService userServiceImpl;
	
	/*
	 *  ��֤��½��Ϣ���ɹ���½���������ת������ҳ��
	 * */
	@RequestMapping(value = "/doLogin")
	public String login(final Model model, LoginCondition loginCondition, HttpServletRequest request) {

		//�z���Ñ���
		boolean result = userServiceImpl.checkUserExit(loginCondition);

		if (result) {
			//��ʼ�����Form
			DisplayForm displayForm = new DisplayForm();
			
			//��ԃ�Ñ�Ԕ����Ϣ
			User user= userServiceImpl.findUser(loginCondition.getLoginName());
			displayForm.setUserMessage(user);
			
			//�o�Ñ�Ո���������
			request.getSession().setAttribute(GlobalConst.USER_SESSION_KEY, loginCondition);
			
			//��ԃ�����Ñ��б�
			List<User> userList =  userServiceImpl.findAll();
			displayForm.setUserList(userList);
			
			//��������ʼ������
			model.addAttribute("displayForm",displayForm);
			
			return "welcome/welcome";
			
		} else {
			return "Index";
		}
	}
	
	/*
	 *  �ǳ�����
	 * */
	@RequestMapping("/loginOut")
	public String loginOut(HttpServletRequest request){
		//�Ƴ�����
		request.getSession().removeAttribute(GlobalConst.USER_SESSION_KEY);
		return "Index";
	}
	/*
	 *  ע��ɹ�
	 * */
	@RequestMapping(value="/registerUser")
	public String registerUser(){
		return "Index";
	}
	
	/*
	 * ��ת��ע��ҳ��
	 * */
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String registerPage(){
		return "register";
	}
	
	/*
	 * ��ת�������û�ҳ��
	 * */
	@RequestMapping(value="/user/addUserPage")
	public String addUserPage(final Model model){
		//��ʼ���û�
		User user = new User();
		model.addAttribute("user", user);
		
		//��ѯ��ɫList	
		List<Role> userList = userServiceImpl.findAllRole();
		model.addAttribute("userList", userList);
		
		return "welcome/addUser";
	}
	/*
	 *  �����û�
	 * */
	@RequestMapping("/user/addUser")
	public String addUser(final Model model, @ModelAttribute("user") User user,HttpServletRequest request){
		userServiceImpl.insertUser(user);
		//��ʼ�����Form
		DisplayForm displayForm = new DisplayForm();
		
		//��ԃ�Ñ�Ԕ����Ϣ
		user= userServiceImpl.findUser(user.getLoginName());
		displayForm.setUserMessage(user);
		
		//��ԃ�����Ñ��б�
		List<User> userList =  userServiceImpl.findAll();
		displayForm.setUserList(userList);
		
		//��������ʼ������
		model.addAttribute("displayForm",displayForm);
		return "welcome/welcome";
	}
	
	/*
	 * ɾ���û�
	 * */
	@RequestMapping("/user/deleteUser")
	public String deleteUser(final Model model, @ModelAttribute("displayForm") DisplayForm displayForm ){
		
		//ɾ����Ӧ���û�
		userServiceImpl.deleteUser(displayForm.getRow());
		
		//��ԃ�����Ñ��б�
		List<User> userList =  userServiceImpl.findAll();
		displayForm.setUserList(userList);
		
		//��������ʼ������
		model.addAttribute("displayForm",displayForm);
		return "welcome/welcome";
	}
	
	/*
	 * ����Excel
	 * */
	@RequestMapping(value="/user/exportExcel")
	public String exportExcel(){
		return "welcome/welcome";
	}
}
