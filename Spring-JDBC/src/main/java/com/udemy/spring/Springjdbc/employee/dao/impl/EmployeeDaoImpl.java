package com.udemy.spring.Springjdbc.employee.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.udemy.spring.Springjdbc.employee.dao.EmployeeDao;
import com.udemy.spring.Springjdbc.employee.dao.rowmapper.EmployeeRowMapper;
import com.udemy.spring.Springjdbc.employee.dto.Employee;

import lombok.Data;

@Data
@Component("employeeDao")//using annotation
public class EmployeeDaoImpl implements EmployeeDao {

//	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int create(Employee employee) {
		String sql = "insert into employee values(?,?,?)";
		int result = jdbcTemplate.update(sql, employee.getId(),employee.getFirstName(),employee.getLastName());
		return result;
	}

	@Override
	public int update(Employee employee) {
		String sql = "update employee set firstname=? , lastname=? where id=?";
		int result = jdbcTemplate.update(sql, employee.getFirstName(),employee.getLastName(),employee.getId());
		return result;
	}

	@Override
	public int delete(int id) {
		String sql = "delete from employee where id=?";
		int result = jdbcTemplate.update(sql, id);
		return result;
	}

	@Override
	public Employee read(int id) {
		String sql = "select * from employee where id=?";
		EmployeeRowMapper rowMapper = new EmployeeRowMapper(); 
		Employee employee = jdbcTemplate.queryForObject(sql, rowMapper,id);
		return employee;
	}

	@Override
	public List<Employee> read() {
		String sql = "select * from employee";
		EmployeeRowMapper rowMapper = new EmployeeRowMapper(); 
		List<Employee> listEmployee = jdbcTemplate.query(sql, rowMapper);
		return listEmployee;
	}

}
