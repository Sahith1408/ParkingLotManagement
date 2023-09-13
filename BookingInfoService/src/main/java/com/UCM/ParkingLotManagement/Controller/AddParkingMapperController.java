package com.UCM.ParkingLotManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.UCM.ParkingLotManagement.Exception.InvalidZipCodeException;
import com.UCM.ParkingLotManagement.model.ParkingLotMapper;

/*
 * This is controller class is used to send the data to another API which is parking info service.
 * */
@Controller
@RequestMapping("/mapper-service")
public class AddParkingMapperController {

	@Autowired
	private RestTemplate restTemplate;
	
	ParkingLotMapper mapperModel = new ParkingLotMapper();
	
	@GetMapping("/add-parking-slot")
	public String addParking() {
		return "parking-form";
	}
	

	@PostMapping("/add-parking")
	public String addParkingMapper(@RequestParam ("parkingName") String parkingName,
			@RequestParam ("address") String address,
			@RequestParam ("slotNumber") String slotNumber,
			@RequestParam ("zipCode") long zipCode, Model model, RedirectAttributes redirectAttributes) throws InvalidZipCodeException {

		try {
			if (!String.valueOf(zipCode).matches("^\\d{5}$")) {
				throw new InvalidZipCodeException("Invalid Zip Code, Please Enter 5 Digits valid Zip Code");
			}
		
		mapperModel.setParkingName(parkingName);
		mapperModel.setAddress(address);
		mapperModel.setSlotNumber(slotNumber);
		mapperModel.setZipCode(zipCode);
		restTemplate.postForObject("http://localhost:8091/parking-service/add-parking-slot", mapperModel, ParkingLotMapper.class);
		redirectAttributes.addFlashAttribute("message", "Parking Slot Added Successfully! add more if required.");
		return "redirect:/mapper-service/add-parking-slot";
		} catch (InvalidZipCodeException e) {
			model.addAttribute("errorMessage", e.getMessage());
	        return "parking-form";
		}	
	}

}
