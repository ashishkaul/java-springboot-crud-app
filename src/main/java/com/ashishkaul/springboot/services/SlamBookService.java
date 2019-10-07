package com.ashishkaul.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ashishkaul.springboot.interfaces.*;
import com.ashishkaul.springboot.models.Person;
import com.google.gson.Gson;

@Component
public class SlamBookService implements ISlamBook{
	
	@Autowired
	private IH2Repository h2RepositoryService;
	
	@Override
	public String AddPersonInfo(String data) {
		return h2RepositoryService.Create(data);
	}

	@Override
	public String EditPersonInfo(String data) {
		return h2RepositoryService.Update(data);
		
	}

	@Override
	public void RemovePersonInfo(String data) {
		h2RepositoryService.Delete(data);
		
	}

	@Override
	public String ViewPersonInfo(String data) {
		return h2RepositoryService.ReadOne(data);
		
	}

	@Override
	public List<String> ViewPersonsInfo() {
		return h2RepositoryService.ReadAll();		
	}
	

}