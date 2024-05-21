package com.example.astonjdbc.dto.rowMapper;

import com.example.astonjdbc.dto.Project;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
public class ProjectRowMapper implements RowMapper<Project> {
    @Override
    public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
        Project project = new Project();
        project.setId(rs.getLong("id"));
        project.setProjectName(rs.getString("project_name"));

        Timestamp startTimestamp = rs.getTimestamp("start_date");
        if (startTimestamp != null) {
            project.setStartDate(startTimestamp.toLocalDateTime());
        } else {
            project.setStartDate(null); // Or handle accordingly
        }

        Timestamp endTimestamp = rs.getTimestamp("end_date");
        if (endTimestamp != null) {
            project.setEndDate(endTimestamp.toLocalDateTime());
        } else {
            project.setEndDate(null); // Or handle accordingly
        }

        return project;
    }
}
