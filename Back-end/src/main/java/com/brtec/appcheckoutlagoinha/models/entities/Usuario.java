package com.brtec.appcheckoutlagoinha.models.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.brtec.appcheckoutlagoinha.models.entities.enuns.Perfil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

	@Id
	private String id;
	private String nome;
	private String email;
	private String senha;
	private Perfil perfil;
}
