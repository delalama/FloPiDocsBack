package com.FloPiDocs.FloPiDocs.Content.repository;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.Document;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * The interface Document repository.
 */
@Repository
public interface DocumentRepository extends MongoRepository<Document, String> {
    /**
     * Find by title list.
     *
     * @param title the title
     * @return the list
     */
    List<Document> findByTitle(String title);

    /**
     * Find by purpose list.
     *
     * @param purpose the purpose
     * @return the list
     */
    List<Document> findByPurpose(String purpose);

    /**
     * Find by user id list.
     *
     * @param userId   the user id
     * @param pageable the pageable
     * @return the list
     */
    List<Document> findByUserId(String userId, Pageable pageable);

    /**
     * Find all by user id list.
     *
     * @param userId the user id
     * @return the list
     */
    List<Document> findAllByUserId(String userId);
    Optional<Document> findById(String documentId);
    void deleteAll();

    /**
     * Delete by user id.
     *
     * @param userId the user id
     */
    void deleteByUserId(String userId);

    /**
     * Delete by title.
     *
     * @param title the title
     */
    void deleteByTitle(String title);

    /**
     * Count by user id long.
     *
     * @param userId the user id
     * @return the long
     */
    Long countByUserId(String userId);
    void deleteById(String id );

    /**
     * Find by user id and title contains ignore case list.
     *
     * @param userId the user id
     * @param title  the title
     * @return the list
     */
// find by userId and title
    List<Document> findByUserIdAndTitleContainsIgnoreCase(String userId,String title);

    /**
     * Find by user id and purpose contains ignore case list.
     *
     * @param userId the user id
     * @param title  the title
     * @return the list
     */
// find by userId and purpose
    List<Document> findByUserIdAndPurposeContainsIgnoreCase(String userId,String title);

}