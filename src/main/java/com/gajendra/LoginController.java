package com.gajendra;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gajendra.dao.Userdao;
import com.gajendra.model.Employee;
import com.gajendra.model.Medicine;
import com.gajendra.model.User;

@Controller
public class LoginController {

	@Autowired
	public Userdao userdao;

	@RequestMapping(value = "/home")
	public String welcome(Model model) {
		model.addAttribute("name", "Home Page");
		model.addAttribute("description", "Page yet to be completed!");
		return "home";
	}

	@RequestMapping("/admin")
	public String admin(Model model, Principal principal) {

		String loggedInUserName = principal.getName();
		model.addAttribute("user", loggedInUserName);
		model.addAttribute("name", "Spring Security Custom Login Demo");
		model.addAttribute("description", "Protected page !");
		return "admin";
	}

	@RequestMapping("/user")
	public String user(Model model, Principal principal) {

		String loggedInUserName = principal.getName();
		model.addAttribute("user", loggedInUserName);
		model.addAttribute("name", "Spring Security USER Custom Login Demo");
		model.addAttribute("description", "Protected page for user !");
		return "customer/main";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {

		return "login";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		model.addAttribute("message", "You have successfully logged off from application !");
		return "login";

	}

	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public String loginError(ModelMap model) {
		model.addAttribute("error", "true");
		return "login";

	}

	@RequestMapping(value = "/aboutus")
	public String aboutuss(Model model) {

		User user = new User();
		model.addAttribute("user", user);

		return "aboutus";
	}

	@RequestMapping(value = "/foremployee", method = RequestMethod.GET)
	public String searchemployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "foremployee";
	}

	@RequestMapping(value = "/foremployee", method = RequestMethod.POST)
	public String searchesemployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result,
			Model model) {
		// userdao.storeempid(employee);
		employee = userdao.getempdetails(employee);
		if (employee.getEmpname() == null) {
			model.addAttribute("error", "you are not registered yet !!!!");
			return "foremployee";
		}

		model.addAttribute("employee", employee);
		return "employeed";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model) {

		User user = new User();
		model.addAttribute("user", user);

		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerProcess(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "register";
		} else {
			if (!user.getPassword().equals(user.getMpassword())) {
				model.addAttribute("error", "passwords dont match");
				return "register";
			}
			if (userdao.getUser(user.getUsername()) != null) {
				model.addAttribute("error", "username exists");
				return "register";
			}
			userdao.saveOrUpdate(user);
			return "login";
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateemployee(Model model) {

		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "update";
	}

//	@RequestMapping(value = "/update", method = RequestMethod.POST)
//	public String upemployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result, Model model) {
//
//		userdao.updatedetails(employee);
//		return "foremployee";
//	}

	@RequestMapping(value = "/user/products")
	public String checker(Model model, Principal principal) {
		String user = principal.getName();
		model.addAttribute("user", user);
		model.addAttribute("product", "product");
		return "product";
	}

}
