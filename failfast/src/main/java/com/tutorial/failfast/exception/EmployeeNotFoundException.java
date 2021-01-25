package com.tutorial.failfast.exception;

public class EmployeeNotFoundException extends RuntimeException {

	public EmployeeNotFoundException(int id) {

		super(String.format("Employee with Id %d not found", id));
	}
}
