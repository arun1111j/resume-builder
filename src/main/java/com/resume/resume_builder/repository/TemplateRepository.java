package com.resume.resume_builder.repository;

import com.resume.resume_builder.model.Template;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateRepository extends MongoRepository<Template, String> {
    // Basic CRUD operations are inherited from MongoRepository
}