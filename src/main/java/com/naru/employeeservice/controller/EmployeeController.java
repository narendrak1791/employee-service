package com.naru.employeeservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naru.employeeservice.dto.EmployeeDto;
import com.naru.employeeservice.service.EmployeeService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/employee")
@AllArgsConstructor
public class EmployeeController {

	private EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<?> saveEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
		return new ResponseEntity<EmployeeDto>(employeeService.saveEmployee(employeeDto), HttpStatus.CREATED);
	}

	@GetMapping("/email/{email}")
	public ResponseEntity<?> getEmployeeByEmail(@PathVariable String email) {
		return new ResponseEntity<EmployeeDto>(employeeService.getEmployeeByEmail(email), HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable Long id) {
		return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
	}
}
