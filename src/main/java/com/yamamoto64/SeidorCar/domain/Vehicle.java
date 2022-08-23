package com.yamamoto64.SeidorCar.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicle implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long placa;
	private String color;
	private String brand;
	
	public Vehicle () {
	}

	public Vehicle(Long placa, String color, String brand) {
		super();
		this.placa = placa;
		this.color = color;
		this.brand = brand;
	}

	public Long getPlaca() {
		return placa;
	}

	public void setPlaca(Long placa) {
		this.placa = placa;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public int hashCode() {
		return Objects.hash(placa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return Objects.equals(placa, other.placa);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[Placa: ");
		builder.append(placa);
		builder.append(", color=");
		builder.append(color);
		builder.append(", brand=");
		builder.append(brand);
		builder.append("]");
		return builder.toString();
	}

}
