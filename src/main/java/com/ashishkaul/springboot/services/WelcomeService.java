package com.ashishkaul.springboot.services;

import org.springframework.stereotype.Component;

import com.ashishkaul.springboot.interfaces.*;

@Component
public class WelcomeService implements ISlamBook{
	
	public String GetMessage(String firstName, String lastName) {
		return String.format("Hello and Welcome %s %s", firstName,lastName);
	}

}
