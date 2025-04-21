package com.resume.resume_builder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resume.resume_builder.exception.ResumeNotFoundException;
import com.resume.resume_builder.model.Resume;
import com.resume.resume_builder.repository.ResumeRepository;

@Service
public class ResumeService {

    private final ResumeRepository resumeRepository;

    @Autowired
    public ResumeService(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    public Resume createResume(Resume resume) {
        return resumeRepository.save(resume);
    }

    public List<Resume> getAllResumes() {
        return resumeRepository.findAll();
    }

    public Resume getResumeById(String id) {
        return resumeRepository.findById(id)
                .orElseThrow(() -> new ResumeNotFoundException("Resume not found with id: " + id));
    }

    public Resume updateResume(String id, Resume updatedResume) {
        Resume existing = getResumeById(id);
        existing.setFullName(updatedResume.getFullName());
        existing.setEmail(updatedResume.getEmail());
        existing.setPhone(updatedResume.getPhone());
        existing.setSummary(updatedResume.getSummary());
        existing.setSkills(updatedResume.getSkills());
        existing.setExperience(updatedResume.getExperience());
        existing.setEducation(updatedResume.getEducation());
        return resumeRepository.save(existing);
    }

    public void deleteResume(String id) {
        resumeRepository.deleteById(id);
    }
}