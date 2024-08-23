package com.giri.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giri.dto.EmployeeDto;
import com.giri.entity.Employee;
import com.giri.exception.ResourceNotFoundException;
import com.giri.mapper.EmployeeMapper;
import com.giri.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Employee employee= EmployeeMapper.maptoEmployee(employeeDto);
	     Employee savedEmployee = employeeRepository.save(employee);
	     return EmployeeMapper.maptoEmployeeDto(savedEmployee); 
	}
	
	
	@Override
	public EmployeeDto getEmployeeById(Long id) {
		Employee employee =   employeeRepository.findById(id).orElseThrow(()->
				new ResourceNotFoundException("employee not exist with given id:"+id));
				
		return EmployeeMapper.maptoEmployeeDto(employee);
		
	}
	
	@Override
	public List<EmployeeDto> getAllEmployees(){
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map((employee) ->
		          EmployeeMapper.maptoEmployeeDto(employee))
				  .collect(Collectors.toList());
				
	}


	@Override
	public EmployeeDto updateEmployeeDto(Long id, EmployeeDto updateEmployee) {
		Employee employee =  employeeRepository.findById(id).orElseThrow(()-> new 
				ResourceNotFoundException(""+id));
		
		employee.setFirstName(updateEmployee.getFirstName());
		employee.setLastName(updateEmployee.getLastName());
		employee.setEmailId(updateEmployee.getEmailId());
		Employee employeeupdateobj=  employeeRepository.save(employee);
		
		return EmployeeMapper.maptoEmployeeDto(employeeupdateobj);
		
		
	}

	
}
