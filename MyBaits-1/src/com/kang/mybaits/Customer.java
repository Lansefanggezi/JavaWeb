package com.kang.mybaits;

public class Customer {

	private String username;
	private String userpassword;
	private int  balance;
	
	public String getUsername() {
		return username;
	}
	public Customer() {
		super();
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public Customer(String username, String userpassword, int balance) {
		super();
		this.username = username;
		this.userpassword = userpassword;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Customer [username=" + username + ", userpassword=" + userpassword + ", balance=" + balance + "]";
	}
	
}
