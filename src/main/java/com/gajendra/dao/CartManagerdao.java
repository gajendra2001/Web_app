package com.gajendra.dao;

import java.util.List;

import com.gajendra.model.CartItem;
import com.gajendra.model.CartManager;

public interface CartManagerdao {
	public void addtocart(int medid, String username, int qnt);
	public List<CartItem> getCartItem (String username);
	public Integer getCartTotalprice (String username);
	public void placeOrder (String username, List<CartItem> list);
	public boolean isCartEmpty (String username);
//	public List<Cart> getcart(String uid);
//	public void addquantity(int quantity,int iid,String uid,Cart cart);
//	public void deleteItem(int itemId,String uid);
//	public float gettotal(String uid);

}
