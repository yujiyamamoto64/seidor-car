package com.yamamoto64.SeidorCar.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yamamoto64.SeidorCar.domain.Driver;
import com.yamamoto64.SeidorCar.services.DriverService;

@RestController
@RequestMapping(value = "/drivers")
public class DriverResource {

	@Autowired
	private DriverService driverService;
	
	@GetMapping
	public ResponseEntity<List<Driver>> findAll() {
		List<Driver> list = driverService.findAll();
		return ResponseEntity.ok().body(list);
	}
}
