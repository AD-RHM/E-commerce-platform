package com.RAHMANE.E_commerce.platforme;

import Entities.User;
import Entities.Role;
import Repositories.UserRepo;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDateTime;


@SpringBootApplication(scanBasePackages = {"Controllers"})
@EntityScan(basePackages = {"Entities"})
@EnableJpaRepositories(basePackages = {"Repositories"})

public class ECommercePlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommercePlatformApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserRepo userRepo) {
		return args -> {
			User user = User.builder()
					.firstName("John")
					.lastName("Doe")
					.email("john.doe@example.com")
					.password("password_hash")
					.role(Role.USER)
					.createdAt(LocalDateTime.now())
					.build();
			userRepo.save(user);
		};
	}
}

