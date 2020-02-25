package com.love.land;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories
//@EntityScan
public class Application {
	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(Application.class, args);
	}
}