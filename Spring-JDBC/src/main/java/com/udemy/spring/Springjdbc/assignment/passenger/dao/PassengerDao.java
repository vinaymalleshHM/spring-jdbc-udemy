package com.udemy.spring.Springjdbc.assignment.passenger.dao;

import java.util.List;

import com.udemy.spring.Springjdbc.assignment.passenger.dto.Passenger;

public interface PassengerDao {
	int create(Passenger passenger);
	int update(Passenger passenger);
	int delete(int id);
	Passenger read(int id);
	List<Passenger> read();
}
