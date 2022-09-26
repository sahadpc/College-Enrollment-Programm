package com.xoriant.enrollmentapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAutoConfiguration
public class StudentEnrollmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentEnrollmentApplication.class, args);
		
	}

}
