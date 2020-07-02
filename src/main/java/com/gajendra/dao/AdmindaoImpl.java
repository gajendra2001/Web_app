package com.gajendra.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gajendra.model.CartItem;
import com.gajendra.model.Employee;
import com.gajendra.model.Medicine;
import com.gajendra.model.OrderInfo;
import com.gajendra.model.User;

public class AdmindaoImpl implements Admindao {
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public List<User> getallusers()
	{
		List<User> list;
		String sql="select u.username,u.name,u.email,u.phone from users as u,users_roles as ur where ur.role='ROLE_USER' and u.username=ur.user";
	    list = (List<User>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return list;
	}
	public List<Medicine> getAllMeds()
	{
		List<Medicine> list;
		String sql="select * from medicine_data where qnt>0";
	    list = (List<Medicine>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<Medicine>(Medicine.class));
        return list;
	}
	public List<OrderInfo> getAllorders(){
		List<OrderInfo> list;
		String sql="select * from user_order";
	    list = (List<OrderInfo>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<OrderInfo>(OrderInfo.class));
        return list;
		
	}
	public List<Employee> getAllemployees(){
		List<Employee> list;
		String sql="select * from employee";
	    list = (List<Employee>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class));
        return list;
	}
	public void addemployee(Employee employee)
	{
		String sql = "INSERT INTO employee(empid,empname,desig,email,phone,salary) VALUES (?,?,?,?,?,?)";
		jdbcTemplate.update(sql,new Object[] {employee.getEmpid(),employee.getEmpname(),employee.getDesig(),employee.getEmail(),employee.getPhone(),employee.getSalary()});

	}
	public void addmeds(Medicine medicine)
	{
		String sql = "INSERT INTO medicine_data(medid,name,price,qnt) VALUES (?,?,?,?)";
		jdbcTemplate.update(sql,new Object[] {medicine.getMedid(),medicine.getName(),medicine.getPrice(),medicine.getQnt()});
		String dql="INSERT INTO avail(medid,qnt) VALUES (?,?)";
		jdbcTemplate.update(dql,new Object[] {medicine.getMedid(),medicine.getQnt()});


	}
}
