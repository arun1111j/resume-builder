package com.resume.resume_builder.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "templates")
public class Template {
    @Id
    private String id;
    private String name;
    private String htmlContent;
    
    // Constructors
    public Template() {}
    
    public Template(String name, String htmlContent) {
        this.name = name;
        this.htmlContent = htmlContent;
    }
    
    // Getters and Setters
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getHtmlContent() {
        return htmlContent;
    }
    
    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }
}