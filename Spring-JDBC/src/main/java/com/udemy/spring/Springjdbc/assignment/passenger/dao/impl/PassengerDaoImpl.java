package com.udemy.spring.Springjdbc.assignment.passenger.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.udemy.spring.Springjdbc.assignment.passenger.dao.PassengerDao;
import com.udemy.spring.Springjdbc.assignment.passenger.dao.rowmapper.PassengerRowMapper;
import com.udemy.spring.Springjdbc.assignment.passenger.dto.Passenger;
import com.udemy.spring.Springjdbc.employee.dto.Employee;

import lombok.Data;

@Data
@Component("passengerDao")
public class PassengerDaoImpl implements PassengerDao {

	//	private JdbcTemplate jdbcTemplate;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int create(Passenger passenger) {
		String sql = "insert into passenger values(?,?,?)";
		int result = jdbcTemplate.update(sql, passenger.getId(),passenger.getFirstName(),passenger.getLastName());
		return result;
	}

	@Override
	public int update(Passenger passenger) {
		String sql = "update passenger set firstname=? ,lastname=? where id=?";
		int result = jdbcTemplate.update(sql, passenger.getFirstName(),passenger.getLastName(),passenger.getId());
		return result;
	}

	@Override
	public int delete(int id) {
		String sql = "delete from passenger where id=?";
		int result =  jdbcTemplate.update(sql, id);
		return result;
	}

	@Override
	public Passenger read(int id) {
		String sql = "select * from passenger where id=?";
		PassengerRowMapper rowMapper = new PassengerRowMapper();
		Passenger passenger = jdbcTemplate.queryForObject(sql, rowMapper , id);
		return passenger;
	}

	@Override
	public List<Passenger> read() {
		String sql = "select * from passenger";
		PassengerRowMapper rowMapper = new PassengerRowMapper();
		List<Passenger> passengersList = jdbcTemplate.query(sql, rowMapper);
		return passengersList;
	}

}
