package com.example.astonjdbc.repository;

import com.example.astonjdbc.dto.Passport;

import java.util.List;


public interface PassportRepository {

    Passport create(Passport passport);

    Passport update(Passport passport);

    Passport findById(Long id);

    List<Passport> findAll();

    void delete(Long id);
}
