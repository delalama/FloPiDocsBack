package com.FloPiDocs.FloPiDocs.Content.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Owner repository.
 */
@Repository
public interface OwnerRepository extends MongoRepository<OwnerRepository, String> {


}