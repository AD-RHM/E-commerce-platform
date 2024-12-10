package com.RAHMANE.E_commerce.platforme;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "Controllers")
public class ECommercePlatformeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommercePlatformeApplication.class, args);
	}

}
