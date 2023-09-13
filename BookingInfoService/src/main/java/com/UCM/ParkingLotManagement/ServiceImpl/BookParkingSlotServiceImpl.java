package com.UCM.ParkingLotManagement.ServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ParkingInfoService.ParkingInfoService.Model.ParkingLotModel;
import com.UCM.ParkingLotManagement.Repository.BookParkingSlotRepo;
import com.UCM.ParkingLotManagement.Service.BookParkingSlotService;
import com.UCM.ParkingLotManagement.model.BookParkingSlotModel;

@Service
public class BookParkingSlotServiceImpl implements BookParkingSlotService{

	@Autowired
	private BookParkingSlotRepo repo;
	private List<BookParkingSlotModel> findAll;
	private Optional<BookParkingSlotModel> findById;
	
	@Autowired
	private RestTemplate restTemplate;

	
	@Override
	public void bookAParkingSlotService(BookParkingSlotModel bookSlot) {
		repo.save(bookSlot);
		
	}

	@Override
	public List<BookParkingSlotModel> getAllDetails() {

		findAll = repo.findAll();
		return findAll;
		
	}

	@Override
	public void editBookingDetails(BookParkingSlotModel model) {

		repo.save(model);
	}

	@Override
	public Optional<BookParkingSlotModel> getBookingDetailsById(int id) {
		
		findById = repo.findById(id);
		return findById;
	}
	

	@Override
	public List<ParkingLotModel> getParkingDetailsList(){
		
		String parkingInfoUrl = "http://localhost:8091/parking-service/get-parking-info";
		ResponseEntity<ParkingLotModel[]> responseEntity = restTemplate.getForEntity(parkingInfoUrl, ParkingLotModel[].class);
		List<ParkingLotModel> parkingLotList = Arrays.asList(responseEntity.getBody());
		return parkingLotList;
	}

	@Override
	public void removeBookingInfoById(int id) {
		repo.deleteById(id);
		
	}

}
