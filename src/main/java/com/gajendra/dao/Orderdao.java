package com.gajendra.dao;

import java.util.List;

import com.gajendra.model.CartItem;
import com.gajendra.model.OrderInfo;
import com.gajendra.model.OrderItem;

public interface Orderdao {
	
	public boolean isOrderEmpty (String username);
	public List<OrderInfo> getallOrders (String username);
	public List<CartItem> getOrderdata (int orderid);
	public String getUsername (int orderid);

}
