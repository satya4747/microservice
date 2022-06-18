package com.training.ducat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ApplicationRunnerProduct {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationRunnerProduct.class, args);
	}
}
