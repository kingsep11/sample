package com.example.demo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PersonController {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	PErsonService personService;
	
	@RequestMapping("getallpersons")
	public String getAllPerson() throws InterruptedException {
		String str = personService.getPersons();
		System.out.println(str);
		HttpEntity<Person> entity = new HttpEntity<>(new Person());
		ResponseEntity<String> response =restTemplate.exchange("http://localhost:8080/getallpersons", HttpMethod.GET, entity, String.class);
		return response.getBody();
	}
	
}
