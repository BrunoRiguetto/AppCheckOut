package com.brtec.appcheckoutlagoinha.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brtec.appcheckoutlagoinha.models.dto.UsuarioDTO;
import com.brtec.appcheckoutlagoinha.models.entities.Usuario;
import com.brtec.appcheckoutlagoinha.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public List<UsuarioDTO> buscarTodos(){
		List<Usuario> list = repository.findAll();
		
		return list.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
	}
	
}
