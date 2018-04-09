package com.kang.mybaits;

public class Customer2 {

	private String name;
	private String password;
	private int  balance;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Customer2 [name=" + name + ", password=" + password + ", balance=" + balance + "]";
	}

	
}
