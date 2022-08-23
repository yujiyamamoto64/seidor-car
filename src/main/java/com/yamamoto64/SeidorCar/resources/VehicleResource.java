package com.yamamoto64.SeidorCar.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.yamamoto64.SeidorCar.domain.Vehicle;
import com.yamamoto64.SeidorCar.services.VehicleService;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleResource {
	
	@Autowired
	private VehicleService vehicleService;
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update (@RequestBody Vehicle obj, @PathVariable Long id) {
		obj.setId(id);
		obj = vehicleService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Optional<Vehicle> obj = vehicleService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Vehicle> insert(@RequestBody Vehicle obj) {
		obj = vehicleService.insert(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping
	public ResponseEntity<List<Vehicle>> findAll() {
		List<Vehicle> list = vehicleService.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	
}
