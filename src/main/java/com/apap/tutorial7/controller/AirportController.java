package com.apap.tutorial7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.apap.tutorial7.rest.Setting;

@RestController
@RequestMapping(value="/airport")
public class AirportController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	public RestTemplate rest2() {
		return new RestTemplate();
	}
	
	@GetMapping("/city/{city}")
	public String getAirport(@PathVariable("city") String city) throws Exception {
		String path = Setting.Amadeus_Airport_API + "&term=" + city + "&country=ID&all_airports=true";
		return restTemplate.getForEntity(path, String.class).getBody();
	}
}
