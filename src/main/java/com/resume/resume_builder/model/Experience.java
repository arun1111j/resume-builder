package com.resume.resume_builder.model;

import java.time.LocalDate;

public class Experience {
    private String jobTitle;
    private String company;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    private boolean currentJob;

    // Getters and Setters
    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }
    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public boolean isCurrentJob() { return currentJob; }
    public void setCurrentJob(boolean currentJob) { this.currentJob = currentJob; }
}