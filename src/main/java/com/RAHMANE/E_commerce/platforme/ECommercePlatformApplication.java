package com.RAHMANE.E_commerce.platforme;

import Entities.Role;
import Entities.User;
import Repositories.UserRepo;
import Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@SpringBootApplication(scanBasePackages = {"Controllers","Services"})
@EntityScan(basePackages = {"Entities"})
@EnableJpaRepositories(basePackages = {"Repositories"})


public class ECommercePlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommercePlatformApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(UserRepo userRepo) {
//		return args -> {
//
//			UserServices service = new UserServices();
//			var user = new User();
//			user = service.login("a@gmail.com", "12345");
//			System.out.println(user);
//		};
//	}
}

