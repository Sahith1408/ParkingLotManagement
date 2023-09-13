package com.ParkingInfoService.ParkingInfoService.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


/*
 * this class is entity for this data model.
 * */
@Entity
@Table(name = "parking_slot")
@Data
public class ParkingLotModel {

	public ParkingLotModel() {
		  // no-argument constructor
		}
	
	public ParkingLotModel(ParkingLotModel modelRequest) {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lot_id")
    private int lotId;
    
    @Column(name = "parking_name", nullable = false)
    private String parkingName;
    
    @Column(name = "address", nullable = false)
    private String address;
    
    @Column(name = "slot_number", nullable = false)
    private String slotNumber;
    
    @Column(name = "zip_code", nullable = true)
    private long zipCode;
}
