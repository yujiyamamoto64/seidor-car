package com.yamamoto64.SeidorCar.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.yamamoto64.SeidorCar.domain.Driver;
import com.yamamoto64.SeidorCar.services.DriverService;

@RestController
@RequestMapping(value = "/drivers")
public class DriverResource {

	@Autowired
	private DriverService driverService;
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Driver obj, @PathVariable Long id) {
		obj.setId(id);
		obj = driverService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Optional<Driver> obj = driverService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete (@PathVariable Long id) {
		driverService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<Driver> insert(@RequestBody Driver obj) {
		obj = driverService.insert(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping
	public ResponseEntity<List<Driver>> findAll() {
		List<Driver> list = driverService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/page")
	public ResponseEntity<Page<Driver>> findPage(
			@RequestParam(value = "page", defaultValue = "0")Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12")Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "name")String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC")String direction) {
		Page<Driver> list = driverService.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}
}
