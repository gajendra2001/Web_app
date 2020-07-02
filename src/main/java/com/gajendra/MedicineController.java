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
import com.gajendra.model.Medicine;

@Controller
public class MedicineController {
	@Autowired
	Medicinedao medicinedao;
	@Autowired
	CartManagerdao cartmanagerdao;

	@RequestMapping(value = "user/buy")
	public String buymeds(Model model) {
		List<Medicine> list = medicinedao.getAllavailMeds();
		model.addAttribute("list", list);
		return "customer/showallmed";
	}

	@RequestMapping(value = "user/addtocart")
	public String buymeds(Model model, HttpServletRequest req) {
		int medid = Integer.parseInt(req.getParameter("medid"));
		int qnt = Integer.parseInt(req.getParameter("qnt"));
		String username = req.getUserPrincipal().getName();

		System.out.println("Uname: " + username);
		System.out.println("Medid: " + medid);
		System.out.println("Qnt: " + qnt);

		cartmanagerdao.addtocart(medid, username, qnt);

		List<Medicine> list = medicinedao.getAllavailMeds();
		model.addAttribute("list", list);
		return "customer/showallmed";
	}

}
