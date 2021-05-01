package com.mlnguyen.mlnguyenrestaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties
@ComponentScan
public class MlnguyenRestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(MlnguyenRestaurantApplication.class, args);
	}

}
