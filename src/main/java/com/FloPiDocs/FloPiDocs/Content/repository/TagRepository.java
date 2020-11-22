package com.FloPiDocs.FloPiDocs.Content.repository;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("ALL")
@Repository
public interface TagRepository extends MongoRepository<Tag, String> {
    public Tag findByTagId(String userId);
    public List<Tag> findByDocumentId(String documentId);
    public List<Tag> findByTagName(String tagName);
    public void deleteByTagId(String tagId);
    public void deleteByDocumentId(String documentId);
    public long count();


    List<Tag> findByUserIdAndTagNameIgnoreCaseContains(String userId, String tagName);
}