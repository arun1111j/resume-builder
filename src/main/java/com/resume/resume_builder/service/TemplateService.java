package com.resume.resume_builder.service;

import com.resume.resume_builder.model.Template;
import com.resume.resume_builder.model.Resume;
import com.resume.resume_builder.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TemplateService {

    @Autowired
    private TemplateRepository templateRepository;

    public List<Template> getAllTemplates() {
        return templateRepository.findAll();
    }

    public Template getTemplateById(String id) {
        return templateRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Template not found with id: " + id));
    }

    public Template createTemplate(Template template) {
        return templateRepository.save(template);
    }

    public void deleteTemplate(String id) {
        if (!templateRepository.existsById(id)) {
            throw new NoSuchElementException("Template not found with id: " + id);
        }
        templateRepository.deleteById(id);
    }

    public String renderResumeHtml(String templateId, Resume resume) {
        Template template = getTemplateById(templateId);
        String html = template.getHtmlContent();

        // Replace placeholders in template with resume values
        html = html.replace("${fullName}", resume.getPersonalInfo().getFullName());
        // Add more as needed:
        // html = html.replace("${email}", resume.getPersonalInfo().getEmail());
        // html = html.replace("${phone}", resume.getPersonalInfo().getPhone());

        return html;
    }
}
