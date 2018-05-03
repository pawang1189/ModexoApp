package com.modexo.model;

public class UserBean {
	
	private String emppassword;
	private String empid;
	private String role="0";

	public UserBean() {
	}

	public UserBean(String empid, String emppassword) {
		this.empid = empid;
		this.emppassword = emppassword;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getEmppassword() {
		return emppassword;
	}

	public void setEmppassword(String emppassword) {
		this.emppassword = emppassword;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

}
