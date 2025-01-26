package com.RAHMANE.E_commerce.platforme;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {"Controllers"})
@EntityScan(basePackages = {"Entities"})
public class ECommercePlatformeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommercePlatformeApplication.class, args);
	}
}

