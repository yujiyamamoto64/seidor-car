package com.yamamoto64.SeidorCar.resources;

import java.net.URI;
import java.util.List;

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

import com.yamamoto64.SeidorCar.domain.Rent;
import com.yamamoto64.SeidorCar.services.RentService;

@RestController
@RequestMapping(value = "/rents")
public class RentResource {

	@Autowired
	private RentService rentService;
	
	@GetMapping
	public ResponseEntity<List<Rent>> findAll() {
		List<Rent> list = rentService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Rent> rentVehicle (@RequestBody Rent obj) {
		obj = rentService.insert(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> finalize(@PathVariable Long id, @RequestBody Rent obj) {
		obj.setId(id);
		obj = rentService.update(obj);
		return ResponseEntity.noContent().build();
	}
}
