package com.brtec.appcheckoutlagoinha.models.entities;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.brtec.appcheckoutlagoinha.models.entities.enuns.Sexo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
public class Crianca {
	
	@Id
	private String id;
	private String nomeCompleto;
	private Instant dataNascimento;
	private Sexo sexo;
	private String nomeResponsavel;
	
	private List<Sala> salas = new ArrayList<>();
	
	public Crianca(String id, String nomeCompleto, Instant dataNascimento, Sexo sexo, String nomeResponsavel) {
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.nomeResponsavel = nomeResponsavel;
	}	
}
