package com.brtec.appcheckoutlagoinha.models.dto;

import com.brtec.appcheckoutlagoinha.models.entities.Sala;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalaDTO {

	private String id;
	private String nome;
	private String descricao;
	private int idadeInicial;
	private int idadeFinal;
	
	public SalaDTO(Sala entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.descricao = entity.getDescricao();
		this.idadeInicial = entity.getIdadeInicial();
		this.idadeFinal = entity.getIdadeFinal();
	}
	
	
}
