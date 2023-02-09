package com.brtec.appcheckoutlagoinha.models.dto;

import java.time.Instant;

import com.brtec.appcheckoutlagoinha.models.entities.Crianca;
import com.brtec.appcheckoutlagoinha.models.entities.enuns.Sexo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CriancaDTO {
	
	
	private String id;
	private String nomeCompleto;
	private Instant dataNascimento;
	private Sexo sexo;
	private String nomeResponsavel;
	
	public CriancaDTO(Crianca entity) {
		this.id = entity.getId();
		this.nomeCompleto = entity.getNomeCompleto();
		this.dataNascimento = entity.getDataNascimento();
		this.sexo = entity.getSexo();
		this.nomeResponsavel = entity.getNomeResponsavel();
	}
	
	

}
