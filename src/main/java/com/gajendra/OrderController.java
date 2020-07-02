package com.gajendra;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gajendra.dao.CartManagerdao;
import com.gajendra.dao.Medicinedao;
import com.gajendra.dao.Orderdao;
import com.gajendra.model.CartItem;
import com.gajendra.model.OrderInfo;
import com.gajendra.model.OrderItem;

@Controller
public class OrderController {
	@Autowired
	Medicinedao medicinedao;
	@Autowired
	CartManagerdao cartmanagerdao;
	@Autowired
	Orderdao orderdao;

	@RequestMapping(value = "user/order")
	public String vieworder(Model model, HttpServletRequest req) {
		String username = req.getUserPrincipal().getName();

		boolean empty = orderdao.isOrderEmpty(username);
		if (empty) {
			return "customer/emptyorder";
		}

		List<OrderInfo> infolist = orderdao.getallOrders(username);
		model.addAttribute("list", infolist);
		return "customer/order";
	}

	@RequestMapping(value = "user/vieworder/{orderid}")
	public String vieworderinfo(Model model, HttpServletRequest req, @PathVariable("orderid") int orderid) {
		String username = req.getUserPrincipal().getName();
		System.out.println(orderid);

		String orname = orderdao.getUsername(orderid);

		if (!orname.equals(username)) {
			return "redirect:/user/order";
		}

		List<CartItem> item = orderdao.getOrderdata(orderid);
		model.addAttribute("list", item);

		return "customer/orderdetails";

	}

}
