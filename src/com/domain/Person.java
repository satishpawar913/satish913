package com.domain;

public class Person {
	private long id;
	private String username;
	private String password;
	private float price;
	private long quantity;


	public Person(long id, String username, String password, float price, long quantity) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.price = price;
		this.quantity = quantity;
	}
	public Person(long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public Person(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	

	@Override
	public String toString() {
		return "Person [id=" + id + ", username=" + username + ", password=" + password + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}

	

	

	


}
