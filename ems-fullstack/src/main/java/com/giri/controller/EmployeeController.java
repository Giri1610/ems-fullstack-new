package com.giri.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.giri.dto.EmployeeDto;
import com.giri.entity.Employee;
import com.giri.exception.ResourceNotFoundException;
import com.giri.repository.EmployeeRepository;
import com.giri.service.EmployeeService;


@RestController
public class EmployeeController {
	
	@Autowired
	private  EmployeeService employeeservice;

    public EmployeeController(EmployeeService employeeservice) {

		this.employeeservice = employeeservice;
    }

	@PostMapping("/employees")
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody   EmployeeDto employeeDto) {
		EmployeeDto savedEmployee =  employeeservice.createEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
		EmployeeDto employeedto = employeeservice.getEmployeeById(id);
		return ResponseEntity.ok(employeedto);
		
	}
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
		 List<EmployeeDto> employees = employeeservice.getAllEmployees();
		 return ResponseEntity.ok(employees);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, 
		@RequestBody EmployeeDto updateEmployee){
		EmployeeDto employeeDto = employeeservice.updateEmployeeDto(id, updateEmployee);
		return ResponseEntity.ok(employeeDto);
		
	}
}
