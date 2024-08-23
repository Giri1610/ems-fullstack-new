package com.giri.service;

import java.util.List;

import com.giri.dto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	
	EmployeeDto getEmployeeById(Long id);

	List<EmployeeDto> getAllEmployees();

	EmployeeDto updateEmployeeDto(Long id, EmployeeDto updateEmployee);
	

}
