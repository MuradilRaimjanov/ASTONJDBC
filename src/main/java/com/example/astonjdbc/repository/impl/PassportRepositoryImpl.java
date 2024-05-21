package com.example.astonjdbc.repository.impl;

import com.example.astonjdbc.repository.PassportRepository;
import com.example.astonjdbc.dto.Passport;
import com.example.astonjdbc.dto.rowMapper.PassportRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PassportRepositoryImpl implements PassportRepository {

    private final NamedParameterJdbcTemplate template;

    public PassportRepositoryImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public Passport create(Passport passport) {
        String sql = """
                INSERT INTO passport (passport_series, passport_number, employee_id)
                VALUES (:passport_series, :passport_number, :employee_id) RETURNING ID;
                """;
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("passport_series", passport.getPassportSeries())
                .addValue("passport_number", passport.getPassportNumber())
                .addValue("employee_id", passport.getEmployeeId());
        Long passportId = template.queryForObject(sql, parameterSource, Long.class);
        passport.setId(passportId);
        return passport;
    }


    @Override
    public Passport update(Passport passport) {
        String sql = """
                UPDATE passport SET passport_series = :passport_series, passport_number = :passport_number, employee_id = :employee_id
                WHERE id = :id
                """;
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", passport.getId())
                .addValue("passport_series", passport.getPassportSeries())
                .addValue("passport_number", passport.getPassportNumber())
                .addValue("employee_id", passport.getEmployeeId());
        template.update(sql, parameterSource);
        return passport;
    }

    @Override
    public Passport findById(Long id) {
        String sql = "SELECT * FROM passport WHERE id = :id";
        SqlParameterSource parameterSource =
                new MapSqlParameterSource("id", id);
        return template.queryForObject(sql, parameterSource, new PassportRowMapper());
    }

    @Override
    public List<Passport> findAll() {
        String sql = "SELECT * FROM passport";
        return template.query(sql, new PassportRowMapper());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM passport WHERE id = :id";
        SqlParameterSource parameterSource =
                new MapSqlParameterSource("id", id);
        template.update(sql, parameterSource);
    }
}
