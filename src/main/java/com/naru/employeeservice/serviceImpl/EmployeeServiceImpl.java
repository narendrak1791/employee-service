package com.naru.employeeservice.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.naru.employeeservice.dto.DepEmpResponseDto;
import com.naru.employeeservice.dto.DepartmentDto;
import com.naru.employeeservice.dto.EmployeeDto;
import com.naru.employeeservice.entity.Employee;
import com.naru.employeeservice.repository.EmployeeRepository;
import com.naru.employeeservice.service.APIClient;
import com.naru.employeeservice.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	private ModelMapper modelMapper;

//	private RestTemplate restTemplate;

//	private WebClient webClient;

	private APIClient apiClient;

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee employee = modelMapper.map(employeeDto, Employee.class);
		return modelMapper.map((employeeRepository.save(employee)), EmployeeDto.class);
	}

	@Override
	public EmployeeDto getEmployeeByEmail(String email) {
		return modelMapper.map((employeeRepository.findByEmail(email)), EmployeeDto.class);
	}

	@Override
	public DepEmpResponseDto getEmployeeById(Long id) {
		Employee employee = employeeRepository.findById(id).get();

		// CODE WHICH HAS BEEN USED TO CALL OTHER SERVICE USING RESTTEMPLATE
		/*
		 * ResponseEntity<DepartmentDto> dprtmtResponseEntity =
		 * restTemplate.getForEntity( "http://localhost:8080/api/department/" +
		 * employee.getDepartmentCode(), DepartmentDto.class); DepartmentDto
		 * departmentDto = dprtmtResponseEntity.getBody();
		 */

		// CODE WHICH HAS BEEN USED TO CALL OTHER SERVICE USING WEBCLIENT
		/*
		 * DepartmentDto departmentDto = webClient.get()
		 * .uri("http://localhost:8080/api/department/" +
		 * employee.getDepartmentCode()).retrieve()
		 * .bodyToMono(DepartmentDto.class).block();
		 */
		
		DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());
		DepEmpResponseDto responseDto = new DepEmpResponseDto();
		responseDto.setDepartmentDto(departmentDto);
		responseDto.setEmployeeDto(modelMapper.map(employee, EmployeeDto.class));
		return responseDto;
	}

}
