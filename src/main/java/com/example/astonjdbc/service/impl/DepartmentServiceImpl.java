package com.example.astonjdbc.service.impl;

import com.example.astonjdbc.repository.DepartmentRepository;
import com.example.astonjdbc.dto.Department;
import com.example.astonjdbc.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    @Override
    public Department create(Department department) {

        return departmentRepository.create(department);
    }

    @Override
    public Department update(Department department) {
        return departmentRepository.update(department);
    }

    @Override
    public Department findById(Long id) {
        return departmentRepository.findById(id);
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        departmentRepository.delete(id);
    }
}
