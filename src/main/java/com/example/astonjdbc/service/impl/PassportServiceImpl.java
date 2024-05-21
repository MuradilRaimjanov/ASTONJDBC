package com.example.astonjdbc.service.impl;

import com.example.astonjdbc.repository.PassportRepository;
import com.example.astonjdbc.dto.Passport;
import com.example.astonjdbc.service.PassportService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassportServiceImpl implements PassportService {

    private final PassportRepository passportRepository;

    public PassportServiceImpl(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    @Override
    public Passport create(Passport passport) {
        return passportRepository.create(passport);
    }

    @Override
    public Passport update(Passport passport) {
        return passportRepository.update(passport);
    }

    @Override
    public Passport findById(Long id) {
        return passportRepository.findById(id);
    }

    @Override
    public List<Passport> findAll() {
        return passportRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        passportRepository.delete(id);
    }
}
