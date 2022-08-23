package com.yamamoto64.SeidorCar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yamamoto64.SeidorCar.domain.Vehicle;
import com.yamamoto64.SeidorCar.repositories.VehicleRepository;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	public Vehicle update(Vehicle obj) {
		Vehicle newObj = findById(obj.getId()).get();
		updateData(newObj, obj);
		return vehicleRepository.save(newObj);
	}
	
	private void updateData(Vehicle newObj, Vehicle obj) {
		newObj.setColor(obj.getColor());
		newObj.setBrand(obj.getBrand());
	}

	public Optional<Vehicle> findById(Long id) {
		Optional<Vehicle> obj = vehicleRepository.findById(id);
		return obj;		
	}
	
	public void delete (Long id) {
		findById(id);
		vehicleRepository.deleteById(id);
	}
	
	public Vehicle insert(Vehicle obj) {
		obj.setId(null);
		obj = vehicleRepository.save(obj);
		return obj;
	}

	public List<Vehicle> findAll() {
		return vehicleRepository.findAll();
	}
}
