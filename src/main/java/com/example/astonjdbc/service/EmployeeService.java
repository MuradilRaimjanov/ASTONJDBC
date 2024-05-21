package com.example.astonjdbc.service;

import com.example.astonjdbc.dto.Employee;

import java.util.List;

public interface EmployeeService {


    Employee create(Employee employee);

    Employee update(Employee employee);

    Employee findById(Long id);

    List<Employee> findAll();

    void delete(Long id);

}
