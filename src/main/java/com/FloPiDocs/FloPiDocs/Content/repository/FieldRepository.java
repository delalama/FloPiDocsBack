package com.FloPiDocs.FloPiDocs.Content.repository;

import com.FloPiDocs.FloPiDocs.Content.entities.Field;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("ALL")
@Repository
public interface FieldRepository extends MongoRepository<Field, String> {
    public Optional<Field> findById(String id);
    public List<Field> findByDocumentId(String documentId);
    public void deleteByDocumentId(String documentId);
    public long count();


}