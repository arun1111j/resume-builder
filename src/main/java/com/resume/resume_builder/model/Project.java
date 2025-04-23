package com.resume.resume_builder.model;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;  // Add this import

@Data
public class Project {
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String projectUrl;
    private List<String> technologiesUsed;
}