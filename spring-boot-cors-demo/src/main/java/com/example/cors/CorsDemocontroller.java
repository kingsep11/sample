package com.example.cors;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/cors/sample/")
public class CorsDemocontroller {

	public String testCors() {
		return "This is cors testing";
	}
}
