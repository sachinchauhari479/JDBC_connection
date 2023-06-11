package com.jsp.jdbc_crud_with_employee.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.jsp.jdbc_crud_with_employee.dto.Employee;
//import com.jsp.jdbc_crud_with_employee.service.List;

/**
 * 
 * @author Sachin_Chaudhary
 *
 */
public class EmployeeDao {
	
	String url="jdbc:mysql://localhost:3306/user";
	String user="root";
	String pass="root";
	
	Connection connection1=null;
	private List<Employee> employees;
	
	/*
	 * save method for employee
	 */

	public Employee saveEmployee(Employee employee) throws SQLException {
		
		Date dateofjoining=null;
		SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			dateofjoining = new Date(dateformat.parse(employee.getEmployeeDateOfJoining()).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*
		 * databse code
		 */
		
		// step-1 load / regoster the driver
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection1=DriverManager.getConnection(url, user, pass);
			
			java.sql.Statement statement= connection1.createStatement();
			
			String insertEmployeeQuery = "insert into employee values("+employee.getEmployeeId()+",'"+employee.getEmployeeName()+"','"+employee.getEmployeeCity()+"',"+employee.getEmployeeSalary()+",'"+dateofjoining+"')";
			
			statement.execute(insertEmployeeQuery);
			return employee;
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
		
		
		
	}
	public int deleteEmployeeById(int employeeId) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection1=DriverManager.getConnection(url, user, pass);
			
			java.sql.Statement statement= connection1.createStatement();
			
			String deleteEmployeeQuery="delete from employee where id="+employeeId;
			int id=statement.executeUpdate(deleteEmployeeQuery);
			return id;
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	/*
	 * update employ city
	 */
	public int updateEmployCity(int employeeId, String employeeCity) {
//		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection1=DriverManager.getConnection(url, user, pass);
			
			java.sql.Statement statement= connection1.createStatement();
			
			String updateEmployeeCity ="update employee set city='"+employeeCity+"' where id ="+employeeId+"";
			int id=statement.executeUpdate(updateEmployeeCity);
			return id;
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
//	public int displayEmployeetable()
	public List<Employee> displayAllEmployee(){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection1=DriverManager.getConnection(url, user, pass);
			
			java.sql.Statement statement= connection1.createStatement();
			
			String displayQuery ="select * from employee";
			ResultSet resultset=statement.executeQuery(displayQuery);
			List<Employee> employees=new ArrayList<Employee>();
			while(resultset.next()) {
				Employee employee=new Employee();
				int id=resultset.getInt("Id");
				String name=resultset.getString("name");
				String city=resultset.getString("city");
				double salary=resultset.getDouble("salary");
				String date=resultset.getDate("dataOfJoining").toString();
				employee.setEmployeeId(id);
				employee.setEmployeeName(name);
				employee.setEmployeeCity(city);
				employee.setEmployeeSalary(salary);
				employee.setEmployeeDateOfJoining(date);
				employees.add(employee);
			}
			return employees;
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	/*
	 * get employe id
	 */
	public Employee getEmployeeId(int employeId) {

		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection1=DriverManager.getConnection(url, user, pass);
			
			java.sql.Statement statement= connection1.createStatement();
			
			String displayQuery ="select * from employee where id="+employeId;
			ResultSet resultset=statement.executeQuery(displayQuery);
			List<Employee> employees=new ArrayList<Employee>();
			if(resultset.next()) {
				Employee employee=new Employee();
				int id=resultset.getInt("Id");
				String name=resultset.getString("name");
				String city=resultset.getString("city");
				double salary=resultset.getDouble("salary");
				String date=resultset.getDate("dataOfJoining").toString();
				employee.setEmployeeId(id);
				employee.setEmployeeName(name);
				employee.setEmployeeCity(city);
				employee.setEmployeeSalary(salary);
				employee.setEmployeeDateOfJoining(date);
				return employee;
			}
		
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	
		
	}
}
