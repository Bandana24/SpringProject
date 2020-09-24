package com.example;
import  org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import  com.example.controller.*;

@SpringBootApplication

//@ComponentScan(basePackages = {"com.example.Controller","com.example.Bean"})

//@ComponentScan(basePackageClasses = BaseController.class)


/*SpringBootApplication annotation already has ComponentScan in it.
 But as the controller class is in a different package, specific mention
 of ComponentScan is required to map the controller package or the 
 Controller package class
  */
 
public class MyfirstSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyfirstSpringBootApplication.class, args);
	}

}
