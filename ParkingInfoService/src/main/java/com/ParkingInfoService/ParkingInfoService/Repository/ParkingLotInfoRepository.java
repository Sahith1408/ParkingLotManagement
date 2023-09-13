package com.ParkingInfoService.ParkingInfoService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ParkingInfoService.ParkingInfoService.Model.ParkingLotModel;


public interface ParkingLotInfoRepository extends JpaRepository<ParkingLotModel, Integer>{


}
