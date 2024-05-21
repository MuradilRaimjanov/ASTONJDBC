package com.example.astonjdbc.service;

import com.example.astonjdbc.dto.EmployeeProject;
import com.example.astonjdbc.dto.Project;

import java.util.List;

public interface ProjectService {

    Project create(Project project);

    Project update(Project project);

    Project findById(Long id);

    List<Project> findAll();

    void delete(Long id);

    void addEmployeeToProject(EmployeeProject employeeProject);
}
