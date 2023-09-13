package com.ParkingInfoService.ParkingInfoService.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ParkingInfoService.ParkingInfoService.Model.ParkingLotModel;
import com.ParkingInfoService.ParkingInfoService.Repository.ParkingLotInfoRepository;
import com.ParkingInfoService.ParkingInfoService.Service.ParkingLotInfoService;

@Service
public class ParkingLotInfoServiceImpl implements ParkingLotInfoService{

	@Autowired
	private ParkingLotInfoRepository repo;
	
	//ParkingLotModel model = new ParkingLotModel();
	
	@Override
	public void saveParkingLotInfo(ParkingLotModel modelMapper) {
		// TODO Auto-generated method stub
		ParkingLotModel model = new ParkingLotModel(modelMapper);
			model.setParkingName(modelMapper.getParkingName());
			model.setAddress(modelMapper.getAddress());
			model.setSlotNumber(modelMapper.getSlotNumber());
			model.setZipCode(modelMapper.getZipCode());
		
		repo.save(model);
		
	}

	@Override
	public List<ParkingLotModel> getParkingInfo() {
		// TODO Auto-generated method stub
		List<ParkingLotModel> listOfSlots = repo.findAll();
		//System.out.println(repo.findById(1));
		System.out.println(listOfSlots);
		return listOfSlots;
	}

	
}
