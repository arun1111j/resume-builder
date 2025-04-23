package com.resume.resume_builder.model;

import lombok.Data;

@Data
public class Skill {
    private String name;
    private String level; // Beginner, Intermediate, Advanced
    private String category; // Technical, Soft, Language, etc.
}