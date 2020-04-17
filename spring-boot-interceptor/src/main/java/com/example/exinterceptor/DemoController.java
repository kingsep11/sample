package com.example.exinterceptor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@RequestMapping("sayHello")
	public String sayHi() {
		System.out.println("Hiiiiiiiiiiiiiiiiiiiii");
		return "Hi";
	}
}
