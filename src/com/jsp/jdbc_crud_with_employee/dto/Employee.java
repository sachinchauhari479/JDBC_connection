package com.jsp.jdbc_crud_with_employee.dto;

/**
 * 
 * @author Sachin_Chaudhary
 * this is employee class 
 *
 */
public class Employee {
	/*
	 * id is primary key
	 */
	private int employeeId;
	private String employeeName;
	private String employeeCity;
	private double employeeSalary;
	private String employeeDateOfJoining;
     //	ctrl+shift+f to make intentaion
	 // alt + s+r to create getter and setter method

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeCity() {
		return employeeCity;
	}

	public void setEmployeeCity(String employeeCity) {
		this.employeeCity = employeeCity;
	}

	public double getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public String getEmployeeDateOfJoining() {
		return employeeDateOfJoining;
	}

	public void setEmployeeDateOfJoining(String employeeDateOfJoining) {
		this.employeeDateOfJoining = employeeDateOfJoining;
	}

}
