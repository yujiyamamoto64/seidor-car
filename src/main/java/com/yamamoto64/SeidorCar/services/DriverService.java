package com.yamamoto64.SeidorCar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yamamoto64.SeidorCar.domain.Driver;
import com.yamamoto64.SeidorCar.repositories.DriverRepository;

@Service
public class DriverService {

	@Autowired
	private DriverRepository driverRepository;
	
	public Driver insert(Driver obj) {
		obj.setId(null);
		obj = driverRepository.save(obj);
		return obj;
	}
	
	public List<Driver> findAll() {
		return driverRepository.findAll();
	}
	
}
