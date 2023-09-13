package com.UCM.ParkingLotManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UCM.ParkingLotManagement.model.BookParkingSlotModel;

/*
 * this class is used to send data to Database using spring data JPA
 * */
public interface BookParkingSlotRepo extends JpaRepository<BookParkingSlotModel, Integer> {
	

}
