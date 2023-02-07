package com.brtec.appcheckoutlagoinha.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brtec.appcheckoutlagoinha.models.dto.UsuarioDTO;
import com.brtec.appcheckoutlagoinha.models.entities.Usuario;
import com.brtec.appcheckoutlagoinha.repositories.UsuarioRepository;
import com.brtec.appcheckoutlagoinha.services.exceptions.ResourceNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public List<UsuarioDTO> buscarTodos(){
		List<Usuario> list = repository.findAll();
		
		return list.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
	}
	
	public UsuarioDTO buscarPorId(UUID usuarioId) {
		Optional<Usuario> resultado = repository.findById(usuarioId);
		Usuario entity = resultado.orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado")); 
	
		return new UsuarioDTO(entity);
	}
	
}
