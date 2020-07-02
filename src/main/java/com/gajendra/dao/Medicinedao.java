package com.gajendra.dao;

import java.util.List;

import com.gajendra.model.Medicine;

public interface Medicinedao {
//	public Item getItem(int itemId);
//	public void deleteItem(int  itemId);
//	public void addItem(Item item);
	public List<Medicine> getAllavailMeds();
}

