package com.naru.employeeservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

	private Long id;
	@NotEmpty(message = "Employee first name should not be empty")
	private String firstName;
	@NotEmpty(message = "Employee last name should not be empty")
	private String lastName;
	@Email
	@NotEmpty(message = "Employee email id should not be empty")
	private String email;
	private String departmentCode;

}
