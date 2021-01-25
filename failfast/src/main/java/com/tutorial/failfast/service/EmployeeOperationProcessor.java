package com.tutorial.failfast.service;

import com.tutorial.failfast.exception.EmployeeNotFoundException;
import com.tutorial.failfast.exception.NoDataFoundException;
import com.tutorial.failfast.model.Employee;
import com.tutorial.failfast.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeOperationProcessor implements EmployeeOperation {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee findById(int id) {

        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAll() {
        final List<Employee> employeeList = new ArrayList<>();
        employeeRepository.findAll().forEach(employee -> employeeList.add(employee));

        if (employeeList.isEmpty()) {

            throw new NoDataFoundException();
        }

        return employeeList;
    }
}
