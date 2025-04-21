package com.resume.resume_builder.repository;

import com.resume.resume_builder.model.Resume;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResumeRepository extends MongoRepository<Resume, String> {
}