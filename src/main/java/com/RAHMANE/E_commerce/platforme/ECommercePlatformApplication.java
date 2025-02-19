package com.RAHMANE.E_commerce.platforme;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication(scanBasePackages = {"Controllers","Services","Configuration"})
@EntityScan(basePackages = {"Entities"})
@EnableJpaRepositories(basePackages = {"Repositories"})

public class ECommercePlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommercePlatformApplication.class, args);
	}

}

