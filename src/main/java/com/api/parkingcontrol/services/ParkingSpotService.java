package com.api.parkingcontrol.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;

@Service
public class ParkingSpotService {
	
	final ParkingSpotRepository parkingSpotRepository;
	public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
		this.parkingSpotRepository = parkingSpotRepository;
	}
	
	@Transactional
	public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
		// TODO Auto-generated method stub
		return parkingSpotRepository.save(parkingSpotModel);
	}
}
