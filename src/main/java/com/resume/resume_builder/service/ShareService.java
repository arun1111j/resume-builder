package com.resume.resume_builder.service;

import com.resume.resume_builder.model.Share;
import com.resume.resume_builder.repository.ShareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ShareService {
    @Autowired
    private ShareRepository shareRepository;

    public Share shareResume(String resumeId, String sharedByUserId, String sharedWithEmail) {
        Share share = new Share(resumeId, sharedByUserId, sharedWithEmail);
        return shareRepository.save(share);
    }

    public List<Share> getSharesByUser(String userId) {
        return shareRepository.findBySharedByUserId(userId);
    }

    public List<Share> getSharesForEmail(String email) {
        return shareRepository.findBySharedWithEmail(email);
    }

    public void markAsViewed(String shareId) {
        shareRepository.findById(shareId).ifPresent(share -> {
            share.setViewed(true);
            share.setViewedAt(LocalDateTime.now());
            shareRepository.save(share);
        });
    }

    public boolean isAlreadyShared(String resumeId, String email) {
        return shareRepository.existsByResumeIdAndSharedWithEmail(resumeId, email);
    }
}