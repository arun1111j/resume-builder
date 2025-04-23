package com.resume.resume_builder.service;

import com.resume.resume_builder.exception.ResumeNotFoundException;
import com.resume.resume_builder.model.Resume;
import com.resume.resume_builder.repository.ResumeRepository;
import com.resume.resume_builder.util.AuthUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;

@Service
public class ResumeService {
    private final ResumeRepository resumeRepository;
    private final PdfService pdfService;

    @Autowired
    public ResumeService(ResumeRepository resumeRepository, PdfService pdfService) {
        this.resumeRepository = resumeRepository;
        this.pdfService = pdfService;
    }

    public Resume createResume(Resume resume) {
        // Set user information from authentication
        resume.setUserId(AuthUtils.getCurrentUserId());
        resume.setUserEmail(AuthUtils.getCurrentUserEmail());
        return resumeRepository.save(resume);
    }

    public Resume getResumeById(String id) {
        Resume resume = resumeRepository.findById(id)
                .orElseThrow(() -> new ResumeNotFoundException("Resume not found with id: " + id));
        
        // Verify ownership
        if (!resume.getUserId().equals(AuthUtils.getCurrentUserId())) {
            throw new AccessDeniedException("You don't have permission to access this resume");
        }
        
        return resume;
    }

    public List<Resume> getResumesForCurrentUser() {
        return resumeRepository.findByUserId(AuthUtils.getCurrentUserId());
    }

    public byte[] generatePdf(String resumeId) throws IOException {
        Resume resume = getResumeById(resumeId);
        String htmlContent = generateHtmlContent(resume); // Implement this method
        return pdfService.generatePdf(htmlContent);
    }

    private String generateHtmlContent(Resume resume) {
        // Implement your HTML template rendering here
        // This is a simple example - you might want to use Thymeleaf or another templating engine
        return String.format("""
            <html>
                <head><title>Resume</title></head>
                <body>
                    <h1>%s</h1>
                    <p>%s</p>
                    <!-- Add more resume content here -->
                </body>
            </html>
            """, 
            resume.getPersonalInfo().getFullName(),
            resume.getPersonalInfo().getSummary()
        );
    }
}