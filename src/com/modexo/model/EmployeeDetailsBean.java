package com.modexo.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EmployeeDetailsBean {

	public EmployeeDetailsBean(){

	}

	private String empname, empcontact, empemail,emprole,emppassword;
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

	public void setEmpdoj(String empdoj) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		//System.out.println("dsfdnfjhdshjdsfjdsjsgdjf "+empdoj);
		this.empdoj = df.parse(empdoj);
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

	public String getEmppassword() {
		return emppassword;
	}

	public void setEmppassword(String emppassword) {
		this.emppassword = emppassword;
	}



}
