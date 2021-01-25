package com.tutorial.failfast.controller;

import java.util.List;

import com.tutorial.failfast.model.Employee;
import com.tutorial.failfast.service.EmployeeOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EmployeeOperation employeeOperation;

	public EmployeeController(EmployeeOperation employeeOperation) {
		this.employeeOperation = employeeOperation;
	}

	@GetMapping(value = "/employee/{id}")
	public Employee getCity(@PathVariable int id) {

		return employeeOperation.findById(id);
	}

	@PostMapping(value= "/employee/save", produces = MediaType.APPLICATION_JSON_VALUE)
	public int save(final @RequestBody Employee employee) {
		log.info("Saving employee details in the database.");
		employeeOperation.save(employee);
		return employee.getId();
	}

	@GetMapping(value= "/employee/getall")
	public List<Employee> getAll() {
		log.info("Getting employee details from the database.");
		return employeeOperation.getAll();
	}
}
