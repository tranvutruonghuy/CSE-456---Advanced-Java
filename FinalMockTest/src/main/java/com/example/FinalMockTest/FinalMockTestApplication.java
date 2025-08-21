package com.example.FinalMockTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FinalMockTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalMockTestApplication.class, args);
	}

}
