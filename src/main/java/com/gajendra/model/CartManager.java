package com.gajendra.model;

public class CartManager {

	String username;
	int medid;
	int qnt;
	String medcinename;
	int price;
	int orderid;

	public CartManager() {
		super();
	}

	public CartManager(String username, int medid, int qnt, String medcinename, int price, int orderid) {
		super();
		this.username = username;
		this.medid = medid;
		this.qnt = qnt;
		this.medcinename = medcinename;
		this.price = price;
		this.orderid = orderid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getMedid() {
		return medid;
	}

	public void setMedid(int medid) {
		this.medid = medid;
	}

	public int getQnt() {
		return qnt;
	}

	public void setQnt(int qnt) {
		this.qnt = qnt;
	}

	public String getMedcinename() {
		return medcinename;
	}

	public void setMedcinename(String medcinename) {
		this.medcinename = medcinename;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

}
