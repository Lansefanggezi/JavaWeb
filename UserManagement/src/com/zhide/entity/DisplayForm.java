package com.zhide.entity;

import java.util.List;

public class DisplayForm {

	//用戶信息
	private User userMessage;
	
	//所以用戶信息
	private List<User> userList;

	//删除行
	private String row;
	
	public User getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(User userMessage) {
		this.userMessage = userMessage;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public String getRow() {
		return row;
	}

	public void setRow(String row) {
		this.row = row;
	}
}
