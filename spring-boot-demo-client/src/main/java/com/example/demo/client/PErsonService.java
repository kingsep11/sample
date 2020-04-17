package com.example.demo.client;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class PErsonService {

	@HystrixCommand(fallbackMethod = "showerrormessage")
	public String getPersons() throws InterruptedException {
		Thread.sleep(500000);
		return "person called";
	}
	
	public String showerrormessage() {
		return "circuit breakes";
	}
}
