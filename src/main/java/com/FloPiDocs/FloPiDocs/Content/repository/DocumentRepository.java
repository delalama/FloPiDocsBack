package com.FloPiDocs.FloPiDocs.Content.repository;

import com.FloPiDocs.FloPiDocs.Content.entities.Document;
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
    List<Document> findByTitleAndPurpose(String title, String purpose, String query);

//    @Query(value = "{'a': {$regex : ?0, $options: 'i'}}")
    List<Document> findByUserIdAndTitleLikeOrPurposeLike(String userId,String a, String b);
    List<Document> findByPurposeLike(String a);
}