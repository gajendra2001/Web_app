package com.gajendra.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.gajendra.model.Employee;
import com.gajendra.model.User;

public interface Userdao{
	@Autowired
	public void saveOrUpdate(User user);
	public void delete(String username);
	public User getUser(String username);
//	public void updatedetails(Employee employee);
	public Employee getempdetails(Employee employee);
	
}