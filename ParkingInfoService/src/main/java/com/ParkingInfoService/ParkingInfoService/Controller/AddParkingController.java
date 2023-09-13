package com.ParkingInfoService.ParkingInfoService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ParkingInfoService.ParkingInfoService.Model.ParkingLotModel;
import com.ParkingInfoService.ParkingInfoService.Service.ParkingLotInfoService;

/*
 * this controller class is used to perform the api mapping related.
 * */

@Controller
@RequestMapping("/parking-service")
public class AddParkingController {

	@Autowired
	private ParkingLotInfoService service;

	@PostMapping(value = "/add-parking-slot")
	public String addParkingInfo(@RequestBody ParkingLotModel modelRequest) {

		
		service.saveParkingLotInfo(modelRequest);
		return "redirect:/http://localhost:8090/mapper-service/add-parking-slot";
	}

	@GetMapping(value = "/get-parking-info")
	@ResponseBody
	public List<ParkingLotModel> getParkingInfo() {

		List<ParkingLotModel> parkingInfo = service.getParkingInfo();

		return parkingInfo;

	}

}
