package com.ashishkaul.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ashishkaul.rest.interfaces.IH2Repository;
import com.ashishkaul.rest.models.Person;
import com.ashishkaul.rest.repository.PersonRepository;
import com.google.gson.Gson;

@Component
public class H2RepositoryService implements IH2Repository{

	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private Gson json;
	@Autowired
	private Optional<Person> person;
	
	@Override
	public String Create(String data) {
		person = Optional.of(json.fromJson(data, Person.class));
		return json.toJson(personRepository.save(person.get()));
	}

	@Override
	public String Update(String id, String data) {
		
		person = GetOneRecord(Long.parseLong(id));
		
		if(person.isPresent()) {
			person = UpdateObject(person, json.fromJson(data, Person.class));
			
			return json.toJson(personRepository.save(person.get()));
		}else {
			return json.toJson("Record not found");
		}
	}

	@Override
	public String Delete(String id) {
		
		person = GetOneRecord(Long.parseLong(id));
		
		if(person.isPresent()) {
			personRepository.delete(person.get());
			return json.toJson("Record deleted successfully");
		}else {
			return json.toJson("Record not found");
		}
				
	}

	@Override
	public String ReadOne(String id) {
		person = GetOneRecord(Long.parseLong(id));
		return json.toJson(person);
	}

	@Override
	public List<String> ReadAll() {
		List<Person> persons = personRepository.findAll();
		return ConvertToStringList(persons);
	}
	
	private Optional<Person> UpdateObject(Optional<Person> oldData, Person newData) {
		oldData.get().setEmail(newData.getEmail());
		oldData.get().setFirstName(newData.getFirstName());
		oldData.get().setLastName(newData.getLastName());
		
		return oldData;
	}
	private Optional<Person> GetOneRecord(long id) {
		return personRepository.findById(id);
	}
	
	private List<String> ConvertToStringList(List<Person> persons) {
		List<String> listOfPersonsAsString = new ArrayList<String>();
		for(Person person : persons) {
			listOfPersonsAsString.add(json.toJson(person));
		}
		return listOfPersonsAsString;
	}

}
