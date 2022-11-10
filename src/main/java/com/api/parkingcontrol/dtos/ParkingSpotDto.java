package com.api.parkingcontrol.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

public @Data class ParkingSpotDto {
	@NotBlank
	private String parkingSpotNumber;
	@NotBlank
	@Size(max = 7)
	private String licensePlateCar;
	@NotBlank
	private String brandCar;
	@NotBlank
	private String modelCar;
	@NotBlank
	private String responsibleName;
	@NotBlank
	private String apartment;
	@NotBlank
	private String block;

}
