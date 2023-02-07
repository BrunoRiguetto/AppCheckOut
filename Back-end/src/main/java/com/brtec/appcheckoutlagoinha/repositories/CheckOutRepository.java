package com.brtec.appcheckoutlagoinha.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.brtec.appcheckoutlagoinha.models.embedded.CheckOut;

@Repository
public interface CheckOutRepository extends MongoRepository<CheckOut, String> {

}
