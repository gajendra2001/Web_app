package com.gajendra.model;

public class CartItem {

	int medid;
	String name;
	int price;
	int qnt;

	int totalprice;

	public CartItem(int medid, String name, int price, int qnt, int totalprice) {
		super();
		this.medid = medid;
		this.name = name;
		this.price = price;
		this.qnt = qnt;
	}

	public CartItem() {
		super();
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public int getQnt() {
		return qnt;
	}

	public void setQnt(int qnt) {
		this.qnt = qnt;
	}

	public int getMedid() {
		return medid;
	}

	public void setMedid(int medid) {
		this.medid = medid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
