package com.resume.resume_builder.controller;

import com.resume.resume_builder.model.Resume;
import com.resume.resume_builder.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/resumes")
public class ResumeController {
    @Autowired
    private ResumeService resumeService;

    @PostMapping
    public ResponseEntity<Resume> createResume(@RequestBody Resume resume) {
        return ResponseEntity.ok(resumeService.createResume(resume));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resume> getResume(@PathVariable String id) {
        return ResponseEntity.ok(resumeService.getResumeById(id));
    }

    @GetMapping("/user")
    public ResponseEntity<List<Resume>> getUserResumes() {
        return ResponseEntity.ok(resumeService.getResumesForCurrentUser());
    }

    @GetMapping("/{id}/pdf")
    public ResponseEntity<byte[]> generatePdf(@PathVariable String id) {
        try {
            byte[] pdf = resumeService.generatePdf(id);
            return ResponseEntity.ok()
                    .header("Content-Type", "application/pdf")
                    .header("Content-Disposition", "attachment; filename=resume.pdf")
                    .body(pdf);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}