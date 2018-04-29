package com.spring.entitiy;

public class Customers {
	private String username;
	private String userpassword;
	private int balance;
	public String getUsername() {
		return username;
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
	public Customers(String username, String userpassword, int balance) {
		super();
		this.username = username;
		this.userpassword = userpassword;
		this.balance = balance;
	}
	public Customers() {
		super();
	}
	@Override
	public String toString() {
		return "customers [username=" + username + ", userpassword=" + userpassword + ", balance=" + balance + "]";
	}
}
