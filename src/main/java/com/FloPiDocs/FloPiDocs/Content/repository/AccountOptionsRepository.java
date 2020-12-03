package com.FloPiDocs.FloPiDocs.Content.repository;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.AccountOptions;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Account options repository.
 */
@Repository
public interface AccountOptionsRepository extends MongoRepository<AccountOptions, String> {
    /**
     * Find by user id list.
     *
     * @param userId the user id
     * @return the list
     */
    List<AccountOptions> findByUserId(String userId);

    /**
     * Delete by user id.
     *
     * @param id the id
     */
    void deleteByUserId(String id);

}