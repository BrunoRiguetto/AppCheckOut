package com.brtec.appcheckoutlagoinha.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.brtec.appcheckoutlagoinha.models.entities.Crianca;

@Repository
public interface CriancaRepository extends MongoRepository<Crianca, String> {

}
