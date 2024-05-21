package com.example.astonjdbc.service;


import com.example.astonjdbc.dto.Passport;

import java.util.List;

public interface PassportService {

    Passport create(Passport passport);

    Passport update(Passport passport);

    Passport findById(Long id);

    List<Passport> findAll();

    void delete(Long id);
}
