package com.resume.resume_builder.dto;

import jakarta.validation.Valid;

import jakarta.validation.constraints.NotBlank;
import java.util.List;

public class ResumeRequest {
    @NotBlank(message = "Template ID is required")
    private String templateId;
    
    @NotBlank(message = "Full name is required")
    private String fullName;
    
    private String email;
    private String phone;
    private String address;
    private String summary;
    
    @Valid
    private List<EducationDto> education;
    
    @Valid
    private List<ExperienceDto> experience;
    private List<String> skills;
    private List<String> certifications;

    // Getters and Setters
    public String getTemplateId() { return templateId; }
    public void setTemplateId(String templateId) { this.templateId = templateId; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }
    public List<EducationDto> getEducation() { return education; }
    public void setEducation(List<EducationDto> education) { this.education = education; }
    public List<ExperienceDto> getExperience() { return experience; }
    public void setExperience(List<ExperienceDto> experience) { this.experience = experience; }
    public List<String> getSkills() { return skills; }
    public void setSkills(List<String> skills) { this.skills = skills; }
    public List<String> getCertifications() { return certifications; }
    public void setCertifications(List<String> certifications) { this.certifications = certifications; }
}