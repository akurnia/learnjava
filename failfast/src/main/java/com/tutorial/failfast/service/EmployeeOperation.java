package com.tutorial.failfast.service;

import com.tutorial.failfast.model.Employee;

import java.util.List;

public interface EmployeeOperation {
    Employee findById(int id);
    List<Employee> getAll();
    void save(Employee employee);
}
