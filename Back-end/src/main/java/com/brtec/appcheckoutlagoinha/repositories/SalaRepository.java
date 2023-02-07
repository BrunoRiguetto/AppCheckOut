package com.brtec.appcheckoutlagoinha.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.brtec.appcheckoutlagoinha.models.entities.Sala;

@Repository
public interface SalaRepository extends MongoRepository<Sala, String>{

}
