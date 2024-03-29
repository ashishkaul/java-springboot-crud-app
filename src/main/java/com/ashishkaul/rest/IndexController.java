package com.ashishkaul.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ashishkaul.rest.interfaces.*;

@RestController
@RequestMapping("/api/v1")
public class IndexController {
	
	@Autowired
	private ISlamBook slamBookService;
	
	@GetMapping("/ViewPersons")
	public List<String> ViewAllPersonsInfo() {
		return slamBookService.ViewPersonsInfo();
	}
	
	@GetMapping("/ViewPersons/{id}")
	public String ViewPersonInfo(@PathVariable String id) {
		return slamBookService.ViewPersonInfo(id);
	}
	
	@PostMapping("/AddPerson")
	public String AddPersonInfo(@Valid @RequestBody String data) {
		return slamBookService.AddPersonInfo(data);
	}
	
	@PutMapping("/EditPerson/{id}")
	public String EditPersonInfo(@PathVariable String id, @Valid @RequestBody String data) {
		return slamBookService.EditPersonInfo(id, data);
	}
	
	@DeleteMapping("/RemovePerson/{id}")
	public void RemovePersonInfo(@PathVariable String id) {
		slamBookService.RemovePersonInfo(id);
	}
	
	
}
