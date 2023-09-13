package com.UCM.ParkingLotManagement.model;

import lombok.Data;

/*
 * This class is used to map the data for rest template
 * */
@Data
public class ParkingLotMapper {
    
   
    private String parkingName;
    
    
    private String address;
    
    
    private String slotNumber;
    
    
    private long zipCode;
}
