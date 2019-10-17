package com.ashishkaul.rest;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
//import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import com.ashishkaul.rest.models.Person;
import com.ashishkaul.rest.services.SlamBookService;
import com.google.gson.Gson;
import org.junit.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
//@WebMvcTest(value = IndexController.class, secure = false)
public class IndexControllerTests {
	@Autowired
//	private MockMvc mockMvc;
	private Person mockPerson;
	@LocalServerPort
	private int randonServerPort;
	@Autowired
	private Gson json;
	@MockBean
	private SlamBookService slamBookService;
	
	private void Setup() {
		mockPerson = new Person();
		mockPerson.setEmail("ashish@gmail.com");
		mockPerson.setFirstName("Ashish");
		mockPerson.setLastName("Kaul");
	}
	
	@Test
	public void TestViewPersonsFailureWhenDBEmpty() throws URISyntaxException {
		Setup();
		RestTemplate restTemplate = new RestTemplate();
		final String baseURL = "http://localhost:"+randonServerPort+"/api/v1/ViewPersons";
		URI uri = new URI(baseURL);
		
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		
		Assert.assertEquals(200, response.getStatusCodeValue());
		Assert.assertEquals(false, response.getBody().contains("persons"));
	}
	
	@Test
	public void TestAddPersonSuccess() throws URISyntaxException {
		
		RestTemplate restTemplate = new RestTemplate();
		final String baseURL = "http://localhost:"+randonServerPort+"/api/v1/AddPerson";
		URI uri = new URI(baseURL);
		HttpHeaders headers = new HttpHeaders();
		Setup();
		HttpEntity<String> request = new HttpEntity<String>(json.toJson(mockPerson), headers);
		
		ResponseEntity<String> response = restTemplate.postForEntity(uri, request, String.class);
		
		Assert.assertEquals(200, response.getStatusCodeValue());
	}
	
	@Test
	public void TestUpdatePersonSuccess() throws URISyntaxException {
		
		RestTemplate restTemplate = new RestTemplate();
		final String baseURL = "http://localhost:"+randonServerPort+"/api/v1/AddPerson";
		URI uri = new URI(baseURL);
		HttpHeaders headers = new HttpHeaders();
		Setup();
		HttpEntity<String> request = new HttpEntity<String>(json.toJson(mockPerson), headers);
		
		restTemplate.put(uri, request);
		
		Assert.assertEquals(200, response.getStatusCodeValue());
	}
	
	@Test
	public void TestDeletePersonSuccess() throws URISyntaxException {
		
		RestTemplate restTemplate = new RestTemplate();
		final String baseURL = "http://localhost:"+randonServerPort+"/api/v1/AddPerson";
		URI uri = new URI(baseURL);
		HttpHeaders headers = new HttpHeaders();
		Setup();
		HttpEntity<String> request = new HttpEntity<String>(json.toJson(mockPerson), headers);
		
		restTemplate.delete(uri);
		
		Assert.assertEquals(200, response.getStatusCodeValue());
	}
}
