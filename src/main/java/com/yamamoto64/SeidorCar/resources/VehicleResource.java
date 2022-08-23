package com.yamamoto64.SeidorCar.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yamamoto64.SeidorCar.domain.Vehicle;
import com.yamamoto64.SeidorCar.services.VehicleService;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleResource {
	
	@Autowired
	private VehicleService vehicleService;

	@GetMapping
	public ResponseEntity<List<Vehicle>> findAll() {
		List<Vehicle> list = vehicleService.findAll();
		return ResponseEntity.ok().body(list);
		
	}
}
