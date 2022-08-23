package com.yamamoto64.SeidorCar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yamamoto64.SeidorCar.domain.Rent;
import com.yamamoto64.SeidorCar.repositories.RentRepository;

@Service
public class RentService {

	@Autowired
	private RentRepository rentRepository;

	public boolean isVehicleAvailable(Rent obj) {
		for (Rent contract : findAll()) {
			if (obj.getVehicle().equals(contract.getVehicle()) && contract.getLastDate() == null) {
				return false;
			}
			if (obj.getVehicle().equals(contract.getVehicle())
					&& obj.getInitialDate().compareTo(contract.getLastDate()) < 0) {
				return false;
			}
		}
		return true;

	}

	public Rent insert(Rent obj) {

		if (isVehicleAvailable(obj)) {
			obj.setId(null);
			obj = rentRepository.save(obj);
			return obj;
		} else {
			return null;
		}

	}

	public Rent update(Rent obj) {
		Rent newObj = findById(obj.getId()).get();
		updateData(newObj, obj);
		return rentRepository.save(newObj);
	}

	private void updateData(Rent newObj, Rent obj) {
		newObj.setLastDate(obj.getLastDate());
	}

	public Optional<Rent> findById(Long id) {
		Optional<Rent> obj = rentRepository.findById(id);
		return obj;
	}

	public List<Rent> findAll() {
		return rentRepository.findAll();
	}
}