package com.RAHMANE.E_commerce.platforme;

import Model.Role;
import Model.User;
import Repositories.UserRepo;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"Controllers"})
@EntityScan(basePackages = {"Model"})
public class ECommercePlatformeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommercePlatformeApplication.class, args);
	}
}

