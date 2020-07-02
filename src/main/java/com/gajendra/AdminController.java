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

import com.gajendra.dao.Admindao;
import com.gajendra.model.CartItem;
import com.gajendra.model.Employee;
import com.gajendra.model.Medicine;
import com.gajendra.model.OrderInfo;
import com.gajendra.model.User;

@Controller
public class AdminController {
	@Autowired
	Admindao admindao;

	@RequestMapping("admin/alluser")
	public String allusers(Model model) {
		List<User> list = admindao.getallusers();
		model.addAttribute("list", list);
		return "admin/alluser";
	}

	@RequestMapping(value = "admin/allmed")
	public String allmeds(Model model) {
	List<Medicine> list = admindao.getAllMeds();
	model.addAttribute("list", list);
		return "admin/allmed";
	}

	@RequestMapping(value = "/admin/addmedicines", method = RequestMethod.GET)
	public String reg(Model model) {

		Medicine medicine = new Medicine();
		model.addAttribute("medicine", medicine);

		return "admin/addmedicines";
	}

	@RequestMapping(value = "/admin/addmedicines", method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute("medicine") Medicine medicine, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "admin/addmedicines";
		}

		admindao.addmeds(medicine);
		return "redirect:/admin/allmed";
	}

	@RequestMapping(value = "admin/order")
	public String allorders(Model model) {
		List<OrderInfo> list = admindao.getAllorders();
		model.addAttribute("list", list);
		return "admin/order";
	}

	@RequestMapping(value = "/admin/employee")
	public String employees(Model model) {
	List<Employee> list = admindao.getAllemployees();
	model.addAttribute("list", list);
		return "admin/employee";
	}

	@RequestMapping(value = "/admin/addemployee", method = RequestMethod.GET)
	public String register(Model model) {

		Employee employee = new Employee();
		model.addAttribute("employee", employee);

		return "admin/addemployee";
	}

	@RequestMapping(value = "/admin/addemployee", method = RequestMethod.POST)
	public String addemployees(@Valid @ModelAttribute("employee") Employee employee, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "admin/addemployee";
		}

		admindao.addemployee(employee);
		return "redirect:/admin/employee";
	}

}
