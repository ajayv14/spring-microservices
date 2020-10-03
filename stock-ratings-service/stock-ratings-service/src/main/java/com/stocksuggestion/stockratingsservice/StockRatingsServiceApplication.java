package com.stocksuggestion.stockratingsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StockRatingsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockRatingsServiceApplication.class, args);
	}

}
