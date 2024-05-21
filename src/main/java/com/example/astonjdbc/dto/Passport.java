package com.example.astonjdbc.dto;

import lombok.Data;

@Data
public class Passport {

    private Long id;

    private String passportSeries;

    private int passportNumber;

    private int employeeId;
}
