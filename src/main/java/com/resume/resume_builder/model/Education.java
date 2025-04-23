package com.resume.resume_builder.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "educations")
public class Education {
    @Id
    private String id;
    private String userId;
    private String institution;
    private String degree;
    private String fieldOfStudy;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean currentlyStudying;
    private String description;

    // Constructors
    public Education() {}

    public Education(String userId, String institution, String degree, String fieldOfStudy, 
                    LocalDate startDate, LocalDate endDate, boolean currentlyStudying, String description) {
        this.userId = userId;
        this.institution = institution;
        this.degree = degree;
        this.fieldOfStudy = fieldOfStudy;
        this.startDate = startDate;
        this.endDate = endDate;
        this.currentlyStudying = currentlyStudying;
        this.description = description;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getInstitution() { return institution; }
    public void setInstitution(String institution) { this.institution = institution; }
    public String getDegree() { return degree; }
    public void setDegree(String degree) { this.degree = degree; }
    public String getFieldOfStudy() { return fieldOfStudy; }
    public void setFieldOfStudy(String fieldOfStudy) { this.fieldOfStudy = fieldOfStudy; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public boolean isCurrentlyStudying() { return currentlyStudying; }
    public void setCurrentlyStudying(boolean currentlyStudying) { this.currentlyStudying = currentlyStudying; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}