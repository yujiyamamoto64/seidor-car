package com.yamamoto64.SeidorCar;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yamamoto64.SeidorCar.domain.Driver;
import com.yamamoto64.SeidorCar.domain.Rent;
import com.yamamoto64.SeidorCar.domain.Vehicle;
import com.yamamoto64.SeidorCar.repositories.DriverRepository;
import com.yamamoto64.SeidorCar.repositories.RentRepository;
import com.yamamoto64.SeidorCar.repositories.VehicleRepository;

@SpringBootApplication
public class SeidorCarApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SeidorCarApplication.class, args);
	}
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private DriverRepository driverRepository;
	
	@Autowired
	private RentRepository rentRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Vehicle v1 = new Vehicle(null, "red", "toyota");
		Vehicle v2 = new Vehicle(null, "blue", "ford");
		Vehicle v3 = new Vehicle(null, "yellow", "fiat");
		
		Driver d1 = new Driver(null, "Carlos");
		Driver d2 = new Driver(null, "Maria");
		Driver d3 = new Driver(null, "João");
		
		vehicleRepository.saveAll(Arrays.asList(v1, v2, v3));
		driverRepository.saveAll(Arrays.asList(d1, d2, d3));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Rent r1 = new Rent(null, sdf.parse("16/02/2022"), sdf.parse("17/02/2022"), d1, v1, "Aluguel de carro");
		
		rentRepository.save(r1);
	}
	
	

}
