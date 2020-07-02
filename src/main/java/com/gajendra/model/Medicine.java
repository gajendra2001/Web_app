package com.gajendra.model;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("deprecation")
public class Medicine {

	int medid;
	@NotEmpty(message = "required")
	String name;

	int price;

	int qnt;

	public Medicine(int medid, String name, int price, int qnt, int totalprice) {
		super();
		this.medid = medid;
		this.name = name;
		this.price = price;
		this.qnt = qnt;
	}

	public Medicine() {
		super();
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
