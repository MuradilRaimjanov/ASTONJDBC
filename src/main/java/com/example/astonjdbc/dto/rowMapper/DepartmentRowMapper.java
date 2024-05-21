package com.example.astonjdbc.dto.rowMapper;

import com.example.astonjdbc.dto.Department;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentRowMapper implements RowMapper<Department> {
    @Override
    public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
        Department department = new Department();
        department.setId(rs.getLong("id"));
        department.setDepartmentName(rs.getString("department_name"));
        return department;
    }
}
