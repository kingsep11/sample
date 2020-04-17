package com.example.exdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@RequestMapping(value = "/sayHi", method = RequestMethod.GET)
	public void sayHello() throws CustomException {
				throw new CustomException("Error occured");
		//return "Hi";
	}
}
