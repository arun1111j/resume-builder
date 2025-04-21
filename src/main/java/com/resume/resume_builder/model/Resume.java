package com.resume.resume_builder.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "resumes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Resume {

    @Id
    private String id;

    private String fullName;
    private String email;
    private String phone;
    private String summary;
    private List<String> skills;
    private List<String> experience;
    private List<String> education;
}