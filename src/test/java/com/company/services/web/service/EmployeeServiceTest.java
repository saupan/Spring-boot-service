package com.company.services.web.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.company.services.web.model.Employee;
import com.company.services.web.repository.EmployeeRepository;



@RunWith(SpringRunner.class)
public class EmployeeServiceTest {

	@TestConfiguration
	static class EmployeeServiceImplTestContextConfiguration {

		@Bean
		public EmployeeService employeeService() {
			return new EmployeeService();
		}
	}

	@Autowired
	private EmployeeService employeeService;

	@MockBean
	private EmployeeRepository employeeRepository;

	
	@Test
	public void whenValidId_thenEmployeeShouldBeFound() {
 
		doReturn(Optional<Employee>.of(new Employee())).when(employeeRepository).findById(anyLong());        
        assertNotNull(employeeService.getEmployeeById(1L));
	 }
	
	//GET /employees (all employees are found)
	//POST /employees (EmployeeIsAdded)
	//GET /employees/id (WhenIdNotFound_then404IsThrown)
	//whenIdisValid_thenEmployeeShouldBeFound
	//PUT /employees/id (WhenIdNotFound_then404IsThrown)
	//WhenIdValid_thenEmployeeShouldBeUpdated
	//DELETE /employees/id (WhenIdNotFound_then404IsThrown)
	//WhenIdValid_thenEmployeeShouldBeDeleted
	
	
}

