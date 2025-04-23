package com.resume.resume_builder.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "resumes")
@Data
public class Resume {
    @Id
    private String id;
    private String userId;
    private String userEmail;
    private PersonalInfo personalInfo;
    private List<Experience> experiences;
    private List<Education> educations;
    private List<Skill> skills;
    private List<Project> projects;
    private String templateId;
    private String shareToken;
    
    // Lombok @Data will generate all getters, setters, toString, equals, hashCode
}