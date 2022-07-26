package com.tahauddin.syed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.config.EnableIntegration;

@SpringBootApplication
@EnableIntegration
public class SpringIntegrationExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationExampleApplication.class, args);
	}

}
