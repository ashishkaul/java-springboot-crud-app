package com.ashishkaul.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ashishkaul.rest.interfaces.*;

@Component
public class SlamBookService implements ISlamBook{
	
	@Autowired
	private IH2Repository h2RepositoryService;
	
	@Override
	public String AddPersonInfo(String data) {
		return h2RepositoryService.Create(data);
	}

	@Override
	public String EditPersonInfo(String id, String data) {
		return h2RepositoryService.Update(id, data);
		
	}

	@Override
	public String RemovePersonInfo(String id) {
		return h2RepositoryService.Delete(id);
		
	}

	@Override
	public String ViewPersonInfo(String id) {
		return h2RepositoryService.ReadOne(id);
		
	}

	@Override
	public List<String> ViewPersonsInfo() {
		return h2RepositoryService.ReadAll();		
	}
	

}
