package com.company.services.web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.company.services.web.exception.ResourceNotFoundException;
import com.company.services.web.model.Employee;
import com.company.services.web.model.Hobby;
import com.company.services.web.repository.EmployeeRepository;
import com.company.services.web.repository.HobbyRepository;

@Transactional
@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;


	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		employeeRepository.findAll().forEach(employees::add);
		return employees;
	}


	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}


	public Employee getEmployeeById(Long employeeId) {
		return employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("employee", "id", employeeId));
	}


	public Employee updateEmployee(Long employeeId,
			Employee employeeDetails) {

		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("employee", "id", employeeId));

		employee.setName(employeeDetails.getName());
		employee.setBirthDate(employeeDetails.getBirthDate());
		employee.setEmail(employeeDetails.getEmail());
		employee.setHobbies(employeeDetails.getHobbies());

		Employee updatedemployee = employeeRepository.save(employee);
		return updatedemployee;
	}


	public void deleteEmployee(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("employee", "id", employeeId));

		employeeRepository.delete(employee);
	}
}


