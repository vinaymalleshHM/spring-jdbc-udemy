package com.udemy.spring.Springjdbc.assignment.passenger.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.udemy.spring.Springjdbc.assignment.passenger.dao.PassengerDao;
import com.udemy.spring.Springjdbc.assignment.passenger.dto.Passenger;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/udemy/spring/Springjdbc/assignment/passenger/test/config.xml");
		PassengerDao passengerDao = (PassengerDao) context.getBean("passengerDao");
		Passenger passenger = new Passenger();
		passenger.setId(3);
		passenger.setFirstName("test");
		passenger.setLastName("google");
		//		int result = passengerDao.create(passenger);
		//		System.out.println("number of record inserted are : " + result);
		//		int result = passengerDao.update(passenger);
		//		System.out.println("number of record updated are : " + result);
		//		int result = passengerDao.delete(3);
		//		System.out.println("number of record deleted are : " + result);
		//		Passenger passenger2 = passengerDao.read(2);
		//		System.out.println("Passenger details : " + passenger2);
		List<Passenger> passengersList = passengerDao.read();
		System.out.println("all passenger list " + passengersList);



	}
}
