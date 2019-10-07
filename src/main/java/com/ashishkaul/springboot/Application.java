package com.ashishkaul.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.ashishkaul.springboot")
public class Application {

	public static void main(String[] args){
//		ApplicationContext appContext = SpringApplication.run(Application.class, args);
		SpringApplication.run(Application.class, args);
	}
}