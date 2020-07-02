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
import com.gajendra.model.CartItem;
import com.gajendra.model.Medicine;

@Controller
public class CartManager {

	@Autowired
	Medicinedao medicinedao;
	@Autowired
	CartManagerdao cartmanagerdao;

	@RequestMapping(value = "user/viewcart")
	public String buymeds(Model model, HttpServletRequest req) {
		String username = req.getUserPrincipal().getName();

		boolean empty = cartmanagerdao.isCartEmpty(username);
		if (empty) {
			return "customer/emptycart";
		}

		List<CartItem> list = cartmanagerdao.getCartItem(username);
		Integer total = cartmanagerdao.getCartTotalprice(username);

		model.addAttribute("total", total);
		if (list != null) {
			model.addAttribute("list", list);
			return "customer/cart";
		} else {
			System.out.println("NULL!");
			return "customer/emptycart";
		}
	}

	@RequestMapping(value = "user/placeorder")
	public String placeorder(Model model, HttpServletRequest req) {
		String username = req.getUserPrincipal().getName();

		boolean empty = cartmanagerdao.isCartEmpty(username);
		if (empty) {
			return "customer/emptycart";
		}

		List<CartItem> list = cartmanagerdao.getCartItem(username);
		Integer total = cartmanagerdao.getCartTotalprice(username);

		model.addAttribute("total", total);
		if (list != null)
			model.addAttribute("list", list);
		else
			System.out.println("NULL!");
		cartmanagerdao.placeOrder(username, list);

		model.addAttribute("total", total);
		return "redirect:/user/buy";
	}

}
