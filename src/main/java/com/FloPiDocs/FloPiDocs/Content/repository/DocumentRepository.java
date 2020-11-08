package com.FloPiDocs.FloPiDocs.Content.repository;

import com.FloPiDocs.FloPiDocs.Content.entities.Document;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DocumentRepository extends MongoRepository<Document, String> {
    public List<Document> findByTitle(String title);
    public List<Document> findByPurpose(String purpose);
    public List<Document> findByUserId(String userId, Pageable pageable);
    public List<Document> findAllByUserId(String userId);
    public Optional<Document> findById(String documentId);
    public void deleteAll();
    public void deleteByUserId(String userId);
    public void deleteByTitle(String title);
    Long countByUserId(String userId);
    public void deleteById(String userId);

    List<Document> findByTitleAndPurpose(String title, String purpose, String query);

    List<Document> findByTitleLike(String a);
}