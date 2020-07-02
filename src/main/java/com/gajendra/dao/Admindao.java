package com.gajendra.dao;

import java.util.List;

import com.gajendra.model.Employee;
import com.gajendra.model.Medicine;
import com.gajendra.model.OrderInfo;
import com.gajendra.model.User;

public interface Admindao {

	public List<User> getallusers();

	public List<Medicine> getAllMeds();

	public List<OrderInfo> getAllorders();

	public List<Employee> getAllemployees();

	public void addemployee(Employee employee);

	public void addmeds(Medicine medicine);
	

}
