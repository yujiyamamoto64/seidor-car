package com.yamamoto64.SeidorCar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yamamoto64.SeidorCar.domain.Driver;
import com.yamamoto64.SeidorCar.repositories.DriverRepository;

@Service
public class DriverService {

	@Autowired
	private DriverRepository driverRepository;
	
	public Driver update (Driver obj) {
		Driver newObj = findById(obj.getId()).get();
		updateData(newObj, obj);
		return driverRepository.save(obj);
	}
	
	private void updateData(Driver newObj, Driver obj) {
		newObj.setName(obj.getName());
		
	}

	public Optional<Driver> findById(Long id) {
		Optional<Driver> obj = driverRepository.findById(id);
		return obj;
	}
	
	public Driver insert(Driver obj) {
		obj.setId(null);
		obj = driverRepository.save(obj);
		return obj;
	}
	
	public List<Driver> findAll() {
		return driverRepository.findAll();
	}
	
}
