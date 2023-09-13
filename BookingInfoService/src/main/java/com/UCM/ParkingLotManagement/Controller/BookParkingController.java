package com.UCM.ParkingLotManagement.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.UCM.ParkingLotManagement.Service.BookParkingSlotService;
import com.UCM.ParkingLotManagement.model.BookParkingSlotModel;

/*
 * This controller class will handle all the booking form related API's
*/ 
@Controller
@RequestMapping("/booking-service")
public class BookParkingController {

	@Autowired
	private BookParkingSlotService service;

	private Optional<BookParkingSlotModel> bookingDetailsById;

	@GetMapping(value = "/homePage")
	public String homePage() {

		return "homePage";
	}

	@GetMapping(value = "/book-a-slot")
	public String bookASlot(Model model) {

		model.addAttribute("bookParkingSlot", new BookParkingSlotModel());
		model.addAttribute("parkingLotList", service.getParkingDetailsList());
		return "bookSlot";
	}

	@PostMapping(value = "/book-a-slot")
	public String saveBookingSlot(@ModelAttribute BookParkingSlotModel bookParkingSlot, Model model, RedirectAttributes redirectAttributes)
			throws RuntimeException {

		model.addAttribute("bookParkingSlot", bookParkingSlot);
		
			String phoneNumber = bookParkingSlot.getPhoneNumber();
			if (!phoneNumber.isEmpty() && !phoneNumber.matches("[0-9]{10}")) {
				redirectAttributes.addFlashAttribute("errorMessageForPhoneNumber", "Phone number is Invalid, Enter a valid phone Number");
			}
			if (bookParkingSlot.getStartDate().isEqual(bookParkingSlot.getEndDate())) {
				if (bookParkingSlot.getEndTime().isBefore(bookParkingSlot.getStartTime())) {
					redirectAttributes.addFlashAttribute("timeError", "End time must be after the start time !");
				}
			} 
			else if (!bookParkingSlot.getEndDate().isAfter(bookParkingSlot.getStartDate())) {
				redirectAttributes.addFlashAttribute("errorMessageForDate", "End Date must be after the start date !");
			}
			service.bookAParkingSlotService(bookParkingSlot);
			redirectAttributes.addFlashAttribute("slotBookedMessage", "Your slot is booked, Add more if required!");
			return "redirect:/booking-service/book-a-slot";
		
	}

	@GetMapping(value = "/get-all-details")
	public String getAllDetails(Model model) {

		List<BookParkingSlotModel> allDetails = service.getAllDetails();
		model.addAttribute("bookingList", allDetails);
		return "manageSlots";
	}

	@GetMapping(value = "/edit-booking/{id}")
	public String editBookingDetails(@PathVariable int id, Model model) {

		bookingDetailsById = service.getBookingDetailsById(id);
		model.addAttribute("bookParkingSlot", bookingDetailsById);
		model.addAttribute("parkingLotList", service.getParkingDetailsList());
		return "bookSlot";

	}

	@GetMapping(value = "/delete-booking/{id}")
	public String removeBookingInfoById(@PathVariable("id") int id) {

		service.removeBookingInfoById(id);
		return "redirect:/booking-service/get-all-details";
	}

}
