package com.FloPiDocs.FloPiDocs.Content.repository;

import com.FloPiDocs.FloPiDocs.Content.entities.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface DocumentRepository extends MongoRepository<Document, String> {
    public List<Document> findByTitle(String title);
    public List<Document> findByPurpose(String purpose);
    public List<Document> findByUserId(String userId);
    public void deleteByUserId(String userId);
    public void deleteByTitle(String title);

}