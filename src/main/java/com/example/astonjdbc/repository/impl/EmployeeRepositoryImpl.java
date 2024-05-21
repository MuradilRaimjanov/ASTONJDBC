package com.example.astonjdbc.repository.impl;

import com.example.astonjdbc.repository.EmployeeRepository;
import com.example.astonjdbc.dto.Employee;
import com.example.astonjdbc.dto.rowMapper.EmployeeRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final NamedParameterJdbcTemplate template;

    private final JdbcTemplate jdbcTemplate;

    public EmployeeRepositoryImpl(NamedParameterJdbcTemplate template, JdbcTemplate jdbcTemplate) {
        this.template = template;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Employee create(Employee employee) {
        String sql = """
                INSERT INTO employee (first_name, last_name)
                VALUES (:first_name, :last_name) RETURNING ID;
                """;
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("first_name", employee.getFirstName())
                .addValue("last_name", employee.getLastName());
        Long employeeId = template.queryForObject(sql, parameterSource, Long.class);
        employee.setId(employeeId);
        return employee;
    }


    @Override
    public Employee update(Employee employee) {
        String sql = """
                UPDATE employee SET first_name = :first_name, last_name = :last_name, department_id = :department_id
                WHERE id = :id
                """;
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", employee.getId())
                .addValue("first_name", employee.getFirstName())
                .addValue("last_name", employee.getLastName())
                .addValue("department_id", employee.getDepartmentId());
        template.update(sql, parameterSource);
        return employee;
    }

    @Override
    public Employee findById(Long id) {
        String sql = "SELECT * FROM employee WHERE id = :id";
        SqlParameterSource parameterSource =
                new MapSqlParameterSource("id", id);
        return template.queryForObject(sql, parameterSource, new EmployeeRowMapper());
    }

    @Override
    public List<Employee> findAll() {
        String sql = "SELECT * FROM employee";
        return template.query(sql, new EmployeeRowMapper());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM employee WHERE id = :id";
        SqlParameterSource parameterSource =
                new MapSqlParameterSource("id", id);
        template.update(sql, parameterSource);
    }

}
