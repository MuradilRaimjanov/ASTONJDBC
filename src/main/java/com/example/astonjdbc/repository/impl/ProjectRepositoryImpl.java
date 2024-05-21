package com.example.astonjdbc.repository.impl;

import com.example.astonjdbc.repository.ProjectRepository;
import com.example.astonjdbc.dto.EmployeeProject;
import com.example.astonjdbc.dto.Project;
import com.example.astonjdbc.dto.rowMapper.ProjectRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {

    private final NamedParameterJdbcTemplate template;

    public ProjectRepositoryImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public Project create(Project project) {
        String sql = """
                INSERT INTO project (project_name, start_date)
                VALUES (:project_name, :start_date) RETURNING ID;
                """;
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("project_name", project.getProjectName())
                .addValue("start_date", project.getStartDate());
        Long projectId = template.queryForObject(sql, parameterSource, Long.class);
        project.setId(projectId);
        return project;
    }

    @Override
    public Project update(Project project) {
        String sql = """
                UPDATE project SET project_name = :project_name, start_date = :start_date, end_date = :end_date
                WHERE id = :id
                """;
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", project.getId())
                .addValue("project_name", project.getProjectName())
                .addValue("start_date", project.getStartDate())
                .addValue("end_date", project.getEndDate());
        template.update(sql, parameterSource);
        return project;
    }

    @Override
    public Project findById(Long id) {
        String sql = "SELECT * FROM project WHERE id = :id";
        SqlParameterSource parameterSource =
                new MapSqlParameterSource("id", id);
        return template.queryForObject(sql, parameterSource, new ProjectRowMapper());
    }

    @Override
    public List<Project> findAll() {
        String sql = "SELECT * FROM project";
        return template.query(sql, new ProjectRowMapper());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM project WHERE id = :id";
        SqlParameterSource parameterSource =
                new MapSqlParameterSource("id", id);
        template.update(sql, parameterSource);
    }
    @Override
    public void addEmployeeToProject(EmployeeProject employeeProject) {
        String sql = """
                INSERT INTO employee_project (employee_id, project_id)
                VALUES (:employee_id, :project_id);
                """;
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("employee_id", employeeProject.getEmployeeId())
                .addValue("project_id", employeeProject.getProjectId());
        template.update(sql, parameterSource);
    }
}
