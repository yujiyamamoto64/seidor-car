package com.yamamoto64.SeidorCar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yamamoto64.SeidorCar.domain.Driver;

public interface DriverRepository extends JpaRepository<Driver, Long>{

}
