package com.example.astonjdbc.controller;

import com.example.astonjdbc.repository.impl.EmployeeRepositoryImpl;
import com.example.astonjdbc.dto.Employee;
import com.example.astonjdbc.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeRepositoryImpl repository, EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping()
    public Employee create(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @PutMapping()
    public Employee update(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    @GetMapping("{id}")
    public Employee findById(@PathVariable Long id) {
        return employeeService.findById(id);
    }

    @GetMapping()
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            employeeService.delete(id);
            return new ResponseEntity<>("Successfully", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Some wrong", HttpStatus.BAD_REQUEST);
        }

    }
}
