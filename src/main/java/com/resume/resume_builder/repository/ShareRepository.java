package com.resume.resume_builder.repository;

import com.resume.resume_builder.model.Share;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ShareRepository extends MongoRepository<Share, String> {
    List<Share> findBySharedByUserId(String userId);
    List<Share> findBySharedWithEmail(String email);
    List<Share> findByResumeId(String resumeId);
    boolean existsByResumeIdAndSharedWithEmail(String resumeId, String email);
}