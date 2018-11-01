package com.apap.tutorial7.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.apap.tutorial7.model.FlightModel;
import com.apap.tutorial7.rest.Setting;
import com.apap.tutorial7.service.FlightService;

@RestController
@RequestMapping(value="/flight")
public class FlightController {
	@Autowired
	private FlightService flightService;
	
	@PostMapping(value="/add")
	private FlightModel addFlightSubmit(@RequestBody FlightModel flight) {
		return flightService.addFlight(flight);
	}
	
	@GetMapping("/view/{flightNumber}")
	public FlightModel view(@PathVariable("flightNumber") String flightNumber) {
		FlightModel flight = flightService.getFlightDetailByFlightNumber(flightNumber);
		return flight;
	}
	
	@PutMapping(value = "/update/{flightId}")
	private String updateFlightSubmit(@PathVariable("flightId") long flightId,
			@RequestParam("destination") Optional<String> destination,
			@RequestParam("origin") Optional<String> origin,
			@RequestParam("time") Optional<String> time) {
		FlightModel flight = flightService.getFlightDetailById(flightId);
		if (flight.equals(null)) {
			return "Couldn't find your flight";
		}
		if (destination.isPresent()) {
			flight.setDestination(destination.get());
		}
		if (time.isPresent()) {
			flight.setTime(time.get());
		}
		if (origin.isPresent()) {
			flight.setOrigin(origin.get());
		}
		flightService.updateFlight(flight);
		return "Flight Update Success";
	}
	
	@DeleteMapping(value = "/delete/{flightId}")
	private String deleteFlight(@PathVariable("flightId") long flightId) {
		flightService.deleteFlight(flightId);
		return "Flight has been deleted";
	}
	
	@GetMapping("/all")
    public List<FlightModel> retrieveListFlight() {
        return flightService.getAllFlight();
    }
	
	
}
