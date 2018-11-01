package com.apap.tutorial7.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tutorial7.model.FlightModel;
import com.apap.tutorial7.repository.FlightDB;


@Service
@Transactional
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightDB flightDb;

//	kalo dioverride error
//	@Override
	public FlightModel addFlight(FlightModel flight) {
		return flightDb.save(flight);
	}
	
//	@Override
	public FlightModel getFlightDetailByFlightNumber(String flightNumber) {
		return flightDb.findByFlightNumber(flightNumber);
	}

//	@Override
	public void deleteFlight(long id) {
		flightDb.deleteById(id);
	}

//	@Override
	public void updateFlight(FlightModel flight) {
		flightDb.save(flight);
	}

//	@Override
	public FlightModel getFlightDetailById(long id) {
		return flightDb.findById(id);
	}

	@Override
	public List<FlightModel> getAllFlight() {
		return flightDb.findAll();
	}
	
}
