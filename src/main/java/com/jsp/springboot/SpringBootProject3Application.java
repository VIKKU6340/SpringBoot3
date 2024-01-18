package com.jsp.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootProject3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProject3Application.class, args);
	}

}


//Packages/Layers in SpringBoot
//
//entity- Entity classes
//repository- Interfaces for each entity to perform database operation
//service- Interfaces to provide an abstraction over serviceimpl
//serviceimpl-To give implementation to abstract methods in service layer
//controller-wil contain all the endpoints for the application
//exception-will contain all the custom exception
//utility-It will have all the Helper Classes needed for the application
