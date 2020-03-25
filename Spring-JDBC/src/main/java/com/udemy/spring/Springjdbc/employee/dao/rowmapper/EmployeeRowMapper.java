package com.udemy.spring.Springjdbc.employee.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.udemy.spring.Springjdbc.employee.dto.Employee;

public class EmployeeRowMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setId(rs.getInt(1));
		employee.setFirstName(rs.getString(2));
		employee.setLastName(rs.getString(3));
		return employee;
	}

}
