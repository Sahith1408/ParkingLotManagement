package com.ParkingInfoService.ParkingInfoService.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ParkingInfoService.ParkingInfoService.Model.ParkingLotModel;

@Service
public interface ParkingLotInfoService {

	void saveParkingLotInfo(ParkingLotModel listOfParkingInfo);

	List<ParkingLotModel> getParkingInfo();
}
