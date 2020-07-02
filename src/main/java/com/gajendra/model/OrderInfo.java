package com.gajendra.model;

public class OrderInfo {
	String username;
	int orderid;
	String status;
	String phone;

	public OrderInfo() {
		super();
	}

	public OrderInfo(String username, int orderid, String status, String phone) {
		super();
		this.username = username;
		this.orderid = orderid;
		this.status = status;
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
