package com.giri.mapper;

import com.giri.dto.EmployeeDto;
import com.giri.entity.Employee;

public class EmployeeMapper {

	public static EmployeeDto maptoEmployeeDto(Employee employee) {
		return new EmployeeDto(employee.getId(), employee.getLastName(), employee.getEmailId(),
				employee.getFirstName());

	}

	public static Employee maptoEmployee(EmployeeDto employeeDto) { 
		  return new Employee(
				        employeeDto.getId(),
			            employeeDto.getFirstName(),
	                    employeeDto.getLastName(), 
	                    employeeDto.getEmailId());
			}

}
