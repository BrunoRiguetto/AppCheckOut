package com.brtec.appcheckoutlagoinha.models.dto;

import com.brtec.appcheckoutlagoinha.models.entities.Usuario;
import com.brtec.appcheckoutlagoinha.models.entities.enuns.Perfil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
	
	private String id;
	private String nome;
	private String email;
	private String senha;
	private Perfil perfil;
	
	public UsuarioDTO(Usuario entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.email = entity.getEmail();
		this.senha = entity.getSenha();
		this.perfil = entity.getPerfil();
		
	}

}
