package com.yamamoto64.SeidorCar;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yamamoto64.SeidorCar.domain.Vehicle;
import com.yamamoto64.SeidorCar.repositories.VehicleRepository;

@SpringBootApplication
public class SeidorCarApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SeidorCarApplication.class, args);
	}
	
	@Autowired
	VehicleRepository vehicleRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Vehicle v1 = new Vehicle(null, "red", "toyota");
		Vehicle v2 = new Vehicle(null, "blue", "ford");
		Vehicle v3 = new Vehicle(null, "yellow", "fiat");
		
		vehicleRepository.saveAll(Arrays.asList(v1, v2, v3));
		
	}
	
	

}
