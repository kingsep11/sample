package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EmployeeModel;
import com.example.demo.service.DemoService;

@RestController
@RequestMapping("/jpa")
public class DemoContoller {

	/**
	 * @RequestMapping("/handle")
		 public ResponseEntity<String> handle() {
		   URI location = ...;
		   HttpHeaders responseHeaders = new HttpHeaders();
		   responseHeaders.setLocation(location);
		   responseHeaders.set("MyResponseHeader", "MyValue");
		   return new ResponseEntity<String>("Hello World", responseHeaders, HttpStatus.CREATED);
		 }

	 * 
	 * @return
	 */
	
	@Autowired
	DemoService demoService;
	
	@RequestMapping("/saveEmployee")
	public ResponseEntity<EmployeeModel> saveEmployee(@RequestBody EmployeeModel obj) {
		EmployeeModel savedObj = demoService.saveEmployee(obj);
		return new ResponseEntity<EmployeeModel>(savedObj, HttpStatus.OK);
	}
	
	@RequestMapping("/listAllEmployees")
	public ResponseEntity<List<EmployeeModel>> findAllEmployees(){
		return new ResponseEntity<List<EmployeeModel>> (demoService.findAllEmployees(), HttpStatus.OK);
	}
}
