package com.yamamoto64.SeidorCar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yamamoto64.SeidorCar.domain.Vehicle;
import com.yamamoto64.SeidorCar.repositories.VehicleRepository;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	public Vehicle insert(Vehicle obj) {
		obj.setId(null);
		obj = vehicleRepository.save(obj);
		return obj;
	}

	public List<Vehicle> findAll() {
		return vehicleRepository.findAll();
	}
}
