package com.yamamoto64.SeidorCar.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Rent implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date initialDate;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date lastDate;
	
	private Driver driver;
	private Vehicle vehicle;
	private String rentReason;
	
	public Rent() {
	}

	public Rent(Long id, Date initialDate, Date lastDate, Driver driver, Vehicle vehicle, String rentReason) {
		super();
		this.id = id;
		this.initialDate = initialDate;
		this.lastDate = lastDate;
		this.driver = driver;
		this.vehicle = vehicle;
		this.rentReason = rentReason;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public String getRentReason() {
		return rentReason;
	}

	public void setRentReason(String rentReason) {
		this.rentReason = rentReason;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rent other = (Rent) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
