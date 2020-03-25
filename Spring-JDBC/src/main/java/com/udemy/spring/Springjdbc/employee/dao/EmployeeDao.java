package com.udemy.spring.Springjdbc.employee.dao;

import java.util.List;

import com.udemy.spring.Springjdbc.employee.dto.Employee;

public interface EmployeeDao {
	int create(Employee employee);
	int update(Employee employee);
	int delete(int id);
	Employee read(int id);
	List<Employee> read();
}
