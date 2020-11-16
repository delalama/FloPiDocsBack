package com.FloPiDocs.FloPiDocs.Content.repository;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.Document;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DocumentRepository extends MongoRepository<Document, String> {
    List<Document> findByTitle(String title);
    List<Document> findByPurpose(String purpose);
    List<Document> findByUserId(String userId, Pageable pageable);
    List<Document> findAllByUserId(String userId);
    Optional<Document> findById(String documentId);
    void deleteAll();
    void deleteByUserId(String userId);
    void deleteByTitle(String title);
    Long countByUserId(String userId);
    void deleteById(String userId);

    // find by userId and title
    List<Document> findByUserIdAndTitleContainsIgnoreCase(String userId,String title);
    // find by userId and purpose
    List<Document> findByUserIdAndPurposeContainsIgnoreCase(String userId,String title);

}