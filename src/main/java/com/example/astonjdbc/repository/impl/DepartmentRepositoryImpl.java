package com.example.astonjdbc.repository.impl;

import com.example.astonjdbc.repository.DepartmentRepository;
import com.example.astonjdbc.dto.Department;
import com.example.astonjdbc.dto.rowMapper.DepartmentRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository {

    private final NamedParameterJdbcTemplate template;

    public DepartmentRepositoryImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public Department create(Department department) {

        String sql = """
                INSERT INTO department (department_name)
                VALUES (:department_name) RETURNING ID;
                """;
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("department_name", department.getDepartmentName());
        Long departmentId = template.queryForObject(sql, parameterSource, Long.class);
        department.setId(departmentId);
        return department;
    }

    @Override
    public Department update(Department department) {
        String sql = """
                UPDATE department SET department_name = :department_name
                WHERE id = :id
                """;
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", department.getId())
                .addValue("department_name", department.getDepartmentName());
        template.update(sql, parameterSource);
        return department;
    }

    @Override
    public Department findById(Long id) {
        String sql = "SELECT * FROM department WHERE department.id = :id";
        SqlParameterSource parameterSource =
                new MapSqlParameterSource("id", id);
        return template.queryForObject(sql, parameterSource, new DepartmentRowMapper());
    }

    @Override
    public List<Department> findAll() {
        String sql = "SELECT * FROM department";
        return template.query(sql, new DepartmentRowMapper());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM department WHERE id = :id";
        SqlParameterSource parameterSource =
                new MapSqlParameterSource("id", id);
        template.update(sql, parameterSource);
    }
}
