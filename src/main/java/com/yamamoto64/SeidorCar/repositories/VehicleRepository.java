package com.yamamoto64.SeidorCar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yamamoto64.SeidorCar.domain.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

}
