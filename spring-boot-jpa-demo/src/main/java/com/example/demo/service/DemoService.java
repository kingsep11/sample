package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.converter.EmployeeConverter;
import com.example.demo.model.EmployeeModel;
import com.example.demo.repo.DemoRepository;

@Service
public class DemoService {

	@Autowired
	DemoRepository demoRepository;
	
	@Autowired
	EmployeeConverter employeeConverter;
	
	public EmployeeModel saveEmployee(EmployeeModel obj) {	
		return employeeConverter.convertToModel(demoRepository.save(employeeConverter.convertToRepository(obj)));
	}
	
	
	public List<EmployeeModel> findAllEmployees(){
		List<EmployeeModel> empList = new ArrayList<EmployeeModel>();
		demoRepository.findAll().forEach(employee -> {
			empList.add(employeeConverter.convertToModel(employee));
		});
		
		return empList;
	}
}
