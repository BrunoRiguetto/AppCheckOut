package com.brtec.appcheckoutlagoinha.models.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sala {

	@Id
	private String id;
	private String nome;
	private String descricao;
	private int idadeInicial;
	private int idadeFinal;
		
	public Sala(String nome) {
		this.nome = nome;
	}	

}
