package com.example.astonjdbc.repository;

import com.example.astonjdbc.dto.Employee;

import java.util.List;

public interface EmployeeRepository {


    Employee create(Employee employee);

    Employee update(Employee employee);

    Employee findById(Long id);

    List<Employee> findAll();

    void delete(Long id);

}
