package com.tutorial.failfast.repository;

import com.tutorial.failfast.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
