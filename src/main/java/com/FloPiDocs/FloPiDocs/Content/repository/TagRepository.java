package com.FloPiDocs.FloPiDocs.Content.repository;

import com.FloPiDocs.FloPiDocs.Content.entities.Tag;
import com.FloPiDocs.FloPiDocs.Content.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends MongoRepository<Tag, String> {
    public Tag findByTagId(String userId);
    public List<Tag> findByDocumentId(String documentId);
    public void deleteByTagId();
    public void deleteAllByDocumentId(String documentId);
    public long count();


}