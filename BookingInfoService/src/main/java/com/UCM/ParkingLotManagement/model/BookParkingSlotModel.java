package com.UCM.ParkingLotManagement.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "parkingSlotDetails")
@Data
public class BookParkingSlotModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name = "First_Name", nullable = false)
	private String firstName;
	
	
	@Column(name = "Last_Name", nullable = false)
	private String lastName;
	
	@Column(name = "Phone_Number", nullable = true)
	private String phoneNumber;
	
	@Column(name = "Vehicle_Number", nullable = false)
	private String vehicleNumber;
	
	@Column(name = "Start_Date", nullable = false)
	private LocalDate startDate;
	
	@Column(name = "End_Date", nullable = false)
	private LocalDate endDate;
	
	@Column(name = "Start_Time", nullable = false)
	private LocalTime startTime;

	@Column(name = "End_Time", nullable = false)
	private LocalTime endTime;

	@Column(name = "Parking_Lot_Info", nullable = false)
	private String  parkingLotModel;
	

}
