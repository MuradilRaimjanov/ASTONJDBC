package com.example.astonjdbc.controller;

import com.example.astonjdbc.dto.EmployeeProject;
import com.example.astonjdbc.dto.Project;
import com.example.astonjdbc.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/project")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping()
    public Project create(@RequestBody Project project) {
        return projectService.create(project);
    }

    @PutMapping()
    public Project update(@RequestBody Project project) {
        return projectService.update(project);
    }

    @GetMapping("{id}")
    public Project findById(@PathVariable Long id) {
        return projectService.findById(id);
    }

    @GetMapping()
    public List<Project> findAll() {
        return projectService.findAll();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            projectService.delete(id);
            return new ResponseEntity<>("Successfully", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Some wrong", HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("employee-to-project")
    public ResponseEntity<String> addEmployeeToProject(@RequestBody EmployeeProject employeeProject) {
        projectService.addEmployeeToProject(employeeProject);

        return new ResponseEntity<>("Successfully", HttpStatus.OK);
    }
}
