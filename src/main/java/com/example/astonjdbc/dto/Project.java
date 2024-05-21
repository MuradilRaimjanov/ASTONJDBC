package com.example.astonjdbc.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Project {

    private Long id;
    private String projectName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
