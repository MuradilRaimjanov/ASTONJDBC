package com.example.astonjdbc.repository;

import com.example.astonjdbc.dto.EmployeeProject;
import com.example.astonjdbc.dto.Project;

import java.util.List;

public interface ProjectRepository {

    Project create(Project project);

    Project update(Project project);

    Project findById(Long id);

    List<Project> findAll();

    void delete(Long id);

    void addEmployeeToProject(EmployeeProject employeeProject);
}
