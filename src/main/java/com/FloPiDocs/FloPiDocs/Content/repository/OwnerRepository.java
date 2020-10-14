package com.FloPiDocs.FloPiDocs.Content.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends MongoRepository<OwnerRepository, String> {


}