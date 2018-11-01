package com.apap.tutorial7.service;

import java.util.List;

import com.apap.tutorial7.model.FlightModel;

public interface FlightService {
	FlightModel addFlight(FlightModel flight);
	FlightModel getFlightDetailByFlightNumber(String flightNumber);
	FlightModel getFlightDetailById(long id);
	void deleteFlight(long id);
	void updateFlight(FlightModel flight);
	List<FlightModel> getAllFlight();
}
