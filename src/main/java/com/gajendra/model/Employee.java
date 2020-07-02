package com.gajendra.model;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("deprecation")
public class Employee {

	private int empid;
	@NotEmpty(message = "required")
	private String empname;
	@NotEmpty(message = "required")
	private String desig;
	@NotEmpty(message = "required")
	private String email;
	@NotEmpty(message = "required")
	private String phone;
	float salary;

	public Employee() {
		super();
	}

	public Employee(int empid, String empname, String desig, String email, String phone, float salary) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.desig = desig;
		this.email = email;
		this.phone = phone;
		this.salary = salary;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getDesig() {
		return desig;
	}

	public void setDesig(String desig) {
		this.desig = desig;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

}
