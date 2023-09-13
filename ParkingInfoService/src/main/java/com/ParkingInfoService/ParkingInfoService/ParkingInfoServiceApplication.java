package com.ParkingInfoService.ParkingInfoService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class ParkingInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingInfoServiceApplication.class, args);
	}

}
