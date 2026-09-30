package com.naru.employeeservice.service;

import com.naru.employeeservice.dto.DepEmpResponseDto;
import com.naru.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto saveEmployee(EmployeeDto employeeDto);

	EmployeeDto getEmployeeByEmail(String email);
	
	DepEmpResponseDto getEmployeeById(Long id);
}
