package com.UCM.ParkingLotManagement;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class ParkingLotManagementApplication {

	@Bean
	RestTemplate restTemplate() {
		
		return new RestTemplate();
	}
	public static void main(String[] args) throws IOException, URISyntaxException {
		SpringApplication.run(ParkingLotManagementApplication.class, args);
	}

}
