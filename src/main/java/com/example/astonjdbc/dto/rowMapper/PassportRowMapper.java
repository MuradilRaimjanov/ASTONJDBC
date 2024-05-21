package com.example.astonjdbc.dto.rowMapper;

import com.example.astonjdbc.dto.Passport;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PassportRowMapper implements RowMapper<Passport> {
    @Override
    public Passport mapRow(ResultSet rs, int rowNum) throws SQLException {
        Passport passport = new Passport();
        passport.setPassportSeries(rs.getString("passport_series"));
        passport.setPassportNumber(rs.getInt("passport_number"));
        passport.setEmployeeId(rs.getInt("employee_id"));
        return passport;
    }
}
