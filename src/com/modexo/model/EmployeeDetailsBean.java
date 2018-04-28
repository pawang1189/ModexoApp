package com.modexo.model;

import java.util.Date;

public class EmployeeDetailsBean {
	
	public EmployeeDetailsBean(){
		
	}
	
	private String empname, empcontact, empemail,emprole;
	private double emprate;
	private int empid;
	private Date empdoj;

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

	public Date getEmpdoj() {
		return empdoj;
	}

	public void setEmpdoj(Date empdoj) {
		this.empdoj = empdoj;
	}

	public String getEmpcontact() {
		return empcontact;
	}

	public void setEmpcontact(String empcontact) {
		this.empcontact = empcontact;
	}

	public String getEmpemail() {
		return empemail;
	}

	public void setEmpemail(String empemail) {
		this.empemail = empemail;
	}

	public double getEmprate() {
		return emprate;
	}

	public void setEmprate(double emprate) {
		this.emprate = emprate;
	}

	public String getEmprole() {
		return emprole;
	}

	public void setEmprole(String emprole) {
		this.emprole = emprole;
	}
	
	

}
