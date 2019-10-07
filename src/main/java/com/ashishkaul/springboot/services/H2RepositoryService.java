package com.ashishkaul.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ashishkaul.springboot.interfaces.IH2Repository;
import com.ashishkaul.springboot.models.Person;
import com.ashishkaul.springboot.repository.PersonRepository;
import com.google.gson.Gson;

@Component
public class H2RepositoryService implements IH2Repository{

	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private Gson json;
	@Autowired
	private Person person;
	
	@Override
	public String Create(String data) {
		person = json.fromJson(data, Person.class);
		return json.toJson(personRepository.save(person));
	}

	@Override
	public String Update(String data) {
		person = json.fromJson(data, Person.class);
		person = GetOneRecord(person);
		if(IsNull(person)) {
			personRepository.save(person);
			return "Record successfully updated";
		}else {
			return "Record not found";
		}
	}

	@Override
	public String Delete(String data) {
		person = json.fromJson(data, Person.class);
		person = GetOneRecord(person);
		if(IsNull(person)) {
			personRepository.delete(person);
			return "Record successfully deleted";
		}else {
			return "Record not found";
		}
				
	}

	@Override
	public String ReadOne(String data) {
		person = json.fromJson(data, Person.class);
		return json.toJson(GetOneRecord(person));
	}

	@Override
	public List<String> ReadAll() {
		return (List<String>) json.toJsonTree(personRepository.findAll());
	}
	
	private boolean IsNull(Person person) {
		return (person == null);
	}
	
	private Person GetOneRecord(Person person) {
		return personRepository.getOne(person.getId());
	}

}
