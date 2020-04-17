package com.example.demo.converter;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Employee;
import com.example.demo.model.EmployeeModel;

@Component
public class EmployeeConverter {

	public Employee convertToRepository(EmployeeModel empModel) {
		Employee employee = new Employee();
		employee.setId(empModel.getId());
		employee.setName(empModel.getName());
		employee.setSalary(empModel.getSalary());
		return employee;
	}
	
	
	public EmployeeModel convertToModel(Employee employee) {
		
		EmployeeModel employeeModel = new EmployeeModel();
		employeeModel.setId(employee.getId());
		employeeModel.setName(employee.getName());
		employeeModel.setSalary(employee.getSalary());
		return employeeModel;
		
	}
}
