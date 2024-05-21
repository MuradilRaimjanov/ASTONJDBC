package com.example.astonjdbc.service;

import com.example.astonjdbc.dto.Department;

import java.util.List;

public interface DepartmentService {

    Department create(Department department);

    Department update(Department department);

    Department findById(Long id);

    List<Department> findAll();

    void delete(Long id);



}
