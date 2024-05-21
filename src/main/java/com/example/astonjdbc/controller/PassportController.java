package com.example.astonjdbc.controller;

import com.example.astonjdbc.dto.Passport;
import com.example.astonjdbc.service.PassportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/passport")
public class PassportController {


    private final PassportService passportService;


    public PassportController(PassportService passportService) {
        this.passportService = passportService;
    }


    @PostMapping()
    public Passport create(@RequestBody Passport passport) {
        return passportService.create(passport);
    }

    @PutMapping()
    public Passport update(@RequestBody Passport passport) {
        return passportService.update(passport);
    }

    @GetMapping("{id}")
    public Passport findById(@PathVariable Long id) {
        return passportService.findById(id);
    }

    @GetMapping()
    public List<Passport> findAll() {
        return passportService.findAll();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            passportService.delete(id);
            return new ResponseEntity<>("Successfully", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Some wrong", HttpStatus.BAD_REQUEST);
        }

    }
}
