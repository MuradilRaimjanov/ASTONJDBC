package com.example.astonjdbc.repository;

import com.example.astonjdbc.dto.Department;

import java.util.List;

public interface DepartmentRepository {

    Department create(Department department);

    Department update(Department department);

    Department findById(Long id);

    List<Department> findAll();

    void delete(Long id);

}
