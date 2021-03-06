package com.gajendra.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.gajendra.model.Employee;
import com.gajendra.model.User;

public class UserdaoImpl implements Userdao{
	
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public UserdaoImpl() {
		
	}
	public UserdaoImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	public void saveOrUpdate(User user) {
		 String sql = "INSERT INTO users(username, password,name,email,phone) VALUES (?,?,?,?,?)";
		 jdbcTemplate.update(sql,new Object[] {user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getPhone()});
		 sql = "INSERT INTO users_roles(user,role) VALUES(?,?)";
		 jdbcTemplate.update(sql,new Object[] {user.getUsername(),"ROLE_USER"});
		 
		 //System.out.println("EROOR");
	}
	public void delete(String username) {
		String sql = "DELETE FROM users WHERE username=?";
		jdbcTemplate.update(sql,username);
	}
	public User getUser(String username) {
		String sql = "SELECT * FROM users WHERE username='"+username+"'";
		return jdbcTemplate.query(sql,new ResultSetExtractor<User>() {
		
		public User extractData(ResultSet rs) throws SQLException,DataAccessException{
			if(rs.next()) {
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				return user;
			}
			return null;
		}
		
	});
}

	public Employee getempdetails(Employee employee) {
		// TODO Auto-generated method stub
		String sql="select * from employee where empname='"+employee.getEmpname()+"' and email='"+employee.getEmail()+"'";
		List<Employee> tmp=(List<Employee>)jdbcTemplate.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class));
		employee=tmp.get(0);
		return employee;
	}
}