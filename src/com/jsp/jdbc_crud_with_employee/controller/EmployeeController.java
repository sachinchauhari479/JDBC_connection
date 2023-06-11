package com.jsp.jdbc_crud_with_employee.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.jsp.jdbc_crud_with_employee.dto.Employee;
import com.jsp.jdbc_crud_with_employee.service.EmployeeService;

public class EmployeeController {
	public static void main(String[] args) {
		EmployeeService employeeService= new EmployeeService();
		Scanner scanner = new Scanner(System.in);
		
		Employee employee= new Employee();
		System.out.println("1. INSERT\n2.DELETE\n3.UPDATE\n4.DISPLAY\n5.GETBYID\n6.EXIT");
		System.out.println("please enter your option: ");
		int ch=scanner.nextInt();
		switch(ch) {
		case 1: {
			System.out.println("Please provide employee details");
			System.out.println("enter employee id");
			int id=scanner.nextInt();
			System.out.println("enter the employee name");
			String name=scanner.next();
			System.out.println("enter the employee city");
			String city=scanner.next();
			System.out.println("enter the employee salary");
			Double salary=scanner.nextDouble();
			System.out.println("enter the employee dateofjoining");
			String dateofjoining=scanner.next();
			employee.setEmployeeId(id);
			employee.setEmployeeName(name);
			employee.setEmployeeCity(city);
			employee.setEmployeeSalary(salary);
			employee.setEmployeeDateOfJoining(dateofjoining);
			try {
				employeeService.saveEmployee(employee);
				System.out.println("Data--- inserted");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}break;
		case 2: {
			System.out.println("Please provide employee id to delete");
			System.out.println("enter employee id");
			int id=scanner.nextInt();
			int id1=employeeService.deleteEmployeeById(id);
			if(id1!=0) {
				System.out.println("Data--- Deleted");
				
			}
			else {
				System.out.println("invalid id");
			}
			
			
			
		}break;
		case 3: {
			System.out.println("Please provide employe id and city for update city");
			System.out.println("enter employee id");
			int id=scanner.nextInt();
			System.out.println("enter employee city");
			String city=scanner.next();
			int id1=employeeService.updateEmployCity(id,city);
            if(id1!=0){
                System.out.println("data is update");
            }
            else {
                System.out.println("data is not found");
            }
			
			
		}break;
		case 4: {
			List<Employee> employees=employeeService.displayAllEmployee();
			for(Employee employee2:employees) {
				System.out.println("============================================================");
				System.out.println("EmployeId:"+employee2.getEmployeeId());
				System.out.println("EmployeName:"+employee2.getEmployeeName());
				System.out.println("Employecity:"+employee2.getEmployeeCity());
				System.out.println("Employesalary:"+employee2.getEmployeeSalary());
				System.out.println("Employedate:"+employee2.getEmployeeDateOfJoining());
				System.out.println("============================================================");
			}
		}break;
		case 5: {
			int id=scanner.nextInt();
			Employee employee2=employeeService.getEmployeeId(id);
			
			if(employee2!=null) {
			System.out.println("============================================================");
			System.out.println("EmployeId:"+employee2.getEmployeeId());
			System.out.println("EmployeName:"+employee2.getEmployeeName());
			System.out.println("Employecity:"+employee2.getEmployeeCity());
			System.out.println("Employesalary:"+employee2.getEmployeeSalary());
			System.out.println("Employedate:"+employee2.getEmployeeDateOfJoining());
			System.out.println("============================================================");
			}
			else {
				System.out.println("id is not found");
			}
			
		}break;
		case 6: {
			System.exit(0);
			
		}break;
		
		default:
	        System.out.println("Invalid choice");
	        break;
		}
			
	

		

	}

}
