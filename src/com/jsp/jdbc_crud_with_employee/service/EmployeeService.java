package com.jsp.jdbc_crud_with_employee.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.jdbc_crud_with_employee.dao.EmployeeDao;
import com.jsp.jdbc_crud_with_employee.dto.Employee;

public class EmployeeService {
	
	EmployeeDao employeeDao = new EmployeeDao();

	public Employee saveEmployee(Employee employee) throws SQLException {
		Employee employee2 = null;
		if(employee.getEmployeeId()<=9999) {
		employee2 = employeeDao.saveEmployee(employee);
		}
		else {
			System.out.println("employee id must be 4 digit");
		}
		return employee2;
		
	}
	public int deleteEmployeeById(int employeeId) {
//		return employeeDao.deleteEmployeeById(employeeId);
     	int id= employeeDao.deleteEmployeeById(employeeId);
		return id;
		
		
	}
	public int updateEmployCity(int employeeId, String employeeCity) {
		return employeeDao.updateEmployCity(employeeId, employeeCity);
		
	}
	public List<Employee> displayAllEmployee(){
		
		return employeeDao.displayAllEmployee();
		
	}
	public Employee getEmployeeId(int employeId) {
		return employeeDao.getEmployeeId(employeId);
	}
}
