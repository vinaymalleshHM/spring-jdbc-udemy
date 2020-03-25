package com.udemy.spring.Springjdbc.employee.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.udemy.spring.Springjdbc.employee.dao.EmployeeDao;
import com.udemy.spring.Springjdbc.employee.dto.Employee;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/udemy/spring/Springjdbc/employee/test/config.xml");
		EmployeeDao employeeDao = (EmployeeDao) context.getBean("employeeDao");
		Employee employee = new Employee();
		employee.setId(2);
		employee.setFirstName("diiij");
		employee.setLastName("hhh");
		//		int result = employeeDao.create(employee);
		//		System.out.println("number of record inserted are : " + result);
		//		int result = employeeDao.update(employee);
		//		System.out.println("number of record updated are : " + result);
		//		int result = employeeDao.delete(2);
		//		System.out.println("number of record deleted are : " + result);
		//		Employee employee2 = employeeDao.read(1);
//		System.out.println("Employee Details : " + employee2);
		List<Employee> listEmployee = employeeDao.read();
		System.out.println("Employee List : " + listEmployee);

	}
}
