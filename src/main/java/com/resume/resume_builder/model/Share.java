package com.resume.resume_builder.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "shares")
public class Share {
    @Id
    private String id;
    private String resumeId;
    private String sharedByUserId;
    private String sharedWithEmail;
    private LocalDateTime sharedAt;
    private boolean viewed;
    private LocalDateTime viewedAt;

    // Constructors
    public Share() {}

    public Share(String resumeId, String sharedByUserId, String sharedWithEmail) {
        this.resumeId = resumeId;
        this.sharedByUserId = sharedByUserId;
        this.sharedWithEmail = sharedWithEmail;
        this.sharedAt = LocalDateTime.now();
        this.viewed = false;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getResumeId() { return resumeId; }
    public void setResumeId(String resumeId) { this.resumeId = resumeId; }
    public String getSharedByUserId() { return sharedByUserId; }
    public void setSharedByUserId(String sharedByUserId) { this.sharedByUserId = sharedByUserId; }
    public String getSharedWithEmail() { return sharedWithEmail; }
    public void setSharedWithEmail(String sharedWithEmail) { this.sharedWithEmail = sharedWithEmail; }
    public LocalDateTime getSharedAt() { return sharedAt; }
    public void setSharedAt(LocalDateTime sharedAt) { this.sharedAt = sharedAt; }
    public boolean isViewed() { return viewed; }
    public void setViewed(boolean viewed) { this.viewed = viewed; }
    public LocalDateTime getViewedAt() { return viewedAt; }
    public void setViewedAt(LocalDateTime viewedAt) { this.viewedAt = viewedAt; }
}