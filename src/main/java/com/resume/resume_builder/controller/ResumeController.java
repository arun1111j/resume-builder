package com.resume.resume_builder.controller;

import com.resume.resume_builder.model.Resume;
import com.resume.resume_builder.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resumes")
@CrossOrigin(origins = "*")
public class ResumeController {

    private final ResumeService resumeService;

    @Autowired
    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @PostMapping
    public Resume createResume(@RequestBody Resume resume) {
        return resumeService.createResume(resume);
    }

    @GetMapping
    public List<Resume> getAllResumes() {
        return resumeService.getAllResumes();
    }

    @GetMapping("/{id}")
    public Resume getResumeById(@PathVariable String id) {
        return resumeService.getResumeById(id);
    }

    @PutMapping("/{id}")
    public Resume updateResume(@PathVariable String id, @RequestBody Resume resume) {
        return resumeService.updateResume(id, resume);
    }

    @DeleteMapping("/{id}")
    public void deleteResume(@PathVariable String id) {
        resumeService.deleteResume(id);
    }
}