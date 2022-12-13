package com.example.pa_backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = {"http://localhost:8081", "http://localhost:8080", "*", "http://192.168.1.8:8081"})

public class PaBackendApplication {
	private static final Logger logger = LoggerFactory.getLogger(PaBackendApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PaBackendApplication.class, args);


	}






}
