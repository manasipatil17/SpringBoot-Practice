package com.crud;

import com.crud.controller.StudentController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CruDbySpringBootApplication {

    private final StudentController studentController;

    CruDbySpringBootApplication(StudentController studentController) {
        this.studentController = studentController;
    }

	public static void main(String[] args) {
		SpringApplication.run(CruDbySpringBootApplication.class, args);
		System.err.println("Application is started...");
	}

}
