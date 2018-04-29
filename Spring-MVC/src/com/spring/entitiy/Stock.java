package com.spring.entitiy;

public class Stock {

	private int isbn;
	private int stock;
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "stock [isbn=" + isbn + ", stock=" + stock + "]";
	}
	public Stock(int isbn, int stock) {
		super();
		this.isbn = isbn;
		this.stock = stock;
	}
	public Stock() {
		super();
	}
}
