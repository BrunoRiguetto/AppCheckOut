package com.brtec.appcheckoutlagoinha.repositories;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.brtec.appcheckoutlagoinha.models.entities.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, UUID>{

}
