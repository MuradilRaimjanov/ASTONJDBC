package com.example.astonjdbc.controller;

import com.example.astonjdbc.dto.Department;
import com.example.astonjdbc.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @PostMapping()
    public Department create(@RequestBody Department department) {
        return departmentService.create(department);
    }

    @PutMapping()
    public Department update(@RequestBody Department department) {
        return departmentService.update(department);
    }

    @GetMapping("{id}")
    public Department findById(@PathVariable Long id) {
        return departmentService.findById(id);
    }

    @GetMapping()
    public List<Department> findAll() {
        return departmentService.findAll();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            departmentService.delete(id);
            return new ResponseEntity<>("Successfully", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Some wrong", HttpStatus.BAD_REQUEST);
        }
    }
}
