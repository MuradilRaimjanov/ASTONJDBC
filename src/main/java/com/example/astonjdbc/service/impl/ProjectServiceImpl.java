package com.example.astonjdbc.service.impl;

import com.example.astonjdbc.repository.ProjectRepository;
import com.example.astonjdbc.dto.EmployeeProject;
import com.example.astonjdbc.dto.Project;
import com.example.astonjdbc.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    @Override
    public Project create(Project project) {
        return projectRepository.create(project);
    }

    @Override
    public Project update(Project project) {
        return projectRepository.update(project);
    }

    @Override
    public Project findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        projectRepository.delete(id);
    }

    @Override
    public void addEmployeeToProject(EmployeeProject employeeProject) {
        projectRepository.addEmployeeToProject(employeeProject);
    }
}
