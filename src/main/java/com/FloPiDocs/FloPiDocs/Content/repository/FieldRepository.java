package com.FloPiDocs.FloPiDocs.Content.repository;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.Field;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * The interface Field repository.
 */
@SuppressWarnings("ALL")
@Repository
public interface FieldRepository extends MongoRepository<Field, String> {
    public Optional<Field> findById(String id);

    /**
     * Find by document id list.
     *
     * @param documentId the document id
     * @return the list
     */
    public List<Field> findByDocumentId(String documentId);

    /**
     * Delete by document id.
     *
     * @param documentId the document id
     */
    public void deleteByDocumentId(String documentId);
    public long count();


}