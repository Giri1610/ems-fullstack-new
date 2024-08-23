package com.giri.ems_fullstack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.giri")
@EnableJpaRepositories(basePackages = "com.giri.repository")
@EntityScan(basePackages = "com.giri.entity")
@ComponentScan(basePackages = {"com.giri.controller", "com.giri.service"})
public class EmsFullstackApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmsFullstackApplication.class, args);
	}

}
