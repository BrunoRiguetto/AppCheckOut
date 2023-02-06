package com.brtec.appcheckoutlagoinha.repositories;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.brtec.appcheckoutlagoinha.models.embedded.CheckOut;

@Repository
public interface CheckOutRepository extends MongoRepository<CheckOut, UUID> {

}
