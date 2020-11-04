package com.FloPiDocs.FloPiDocs.Content.repository;

import com.FloPiDocs.FloPiDocs.Content.entities.AccountOptions;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountOptionsRepository extends MongoRepository<AccountOptions, String> {
    public List<AccountOptions> findByUserId(String userId);


}