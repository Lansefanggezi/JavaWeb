package com.spring.entitiy;

public class Price {
	private int isbn;
	private String book_name;
	private String book_price;
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_price() {
		return book_price;
	}
	public void setBook_price(String book_price) {
		this.book_price = book_price;
	}
	@Override
	public String toString() {
		return "price [isbn=" + isbn + ", book_name=" + book_name + ", book_price=" + book_price + "]";
	}
	public Price(int isbn, String book_name, String book_price) {
		super();
		this.isbn = isbn;
		this.book_name = book_name;
		this.book_price = book_price;
	}
	public Price() {
		super();
	}
	
}
