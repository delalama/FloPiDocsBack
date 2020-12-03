package com.FloPiDocs.FloPiDocs.Content.repository;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Tag repository.
 */
@SuppressWarnings("ALL")
@Repository
public interface TagRepository extends MongoRepository<Tag, String> {
    /**
     * Find by tag id tag.
     *
     * @param userId the user id
     * @return the tag
     */
    public Tag findByTagId(String userId);

    /**
     * Find by document id list.
     *
     * @param documentId the document id
     * @return the list
     */
    public List<Tag> findByDocumentId(String documentId);

    /**
     * Find by tag name list.
     *
     * @param tagName the tag name
     * @return the list
     */
    public List<Tag> findByTagName(String tagName);

    /**
     * Delete by tag id.
     *
     * @param tagId the tag id
     */
    public void deleteByTagId(String tagId);

    /**
     * Delete by document id.
     *
     * @param documentId the document id
     */
    public void deleteByDocumentId(String documentId);
    public long count();


    /**
     * Find by user id and tag name ignore case contains list.
     *
     * @param userId  the user id
     * @param tagName the tag name
     * @return the list
     */
    List<Tag> findByUserIdAndTagNameIgnoreCaseContains(String userId, String tagName);
}