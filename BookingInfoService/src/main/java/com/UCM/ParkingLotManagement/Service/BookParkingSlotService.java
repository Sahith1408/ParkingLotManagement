package com.UCM.ParkingLotManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ParkingInfoService.ParkingInfoService.Model.ParkingLotModel;
import com.UCM.ParkingLotManagement.model.BookParkingSlotModel;

@Service
public interface BookParkingSlotService {

	
	 void bookAParkingSlotService(BookParkingSlotModel bookSlot );

	 List<BookParkingSlotModel> getAllDetails();

	void editBookingDetails(BookParkingSlotModel model);

	Optional<BookParkingSlotModel> getBookingDetailsById(int id);
	
	List<ParkingLotModel> getParkingDetailsList();

	void removeBookingInfoById(int id);

}
