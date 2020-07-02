package com.gajendra.model;

public class OrderItem {

	int orderid;
	int medid;
	int qnt;

	int price;
	int totalprice;

	public OrderItem() {
		super();
	}

	public OrderItem(int orderid, int medid, int qnt) {
		super();
		this.orderid = orderid;
		this.medid = medid;
		this.qnt = qnt;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
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

}
