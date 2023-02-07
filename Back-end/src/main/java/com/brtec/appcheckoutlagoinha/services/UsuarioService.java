package com.brtec.appcheckoutlagoinha.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
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
		List<Usuario> lista = repository.findAll();
		
		return lista.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
	}
	
	public UsuarioDTO buscarPorId(String usuarioId) {
		Optional<Usuario> resultado = repository.findById(usuarioId);
		Usuario entity = resultado.orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado")); 
	
		return new UsuarioDTO(entity);
	}
	
	public UsuarioDTO inserir(UsuarioDTO dto) {
		Usuario entity = new Usuario();
		copiaDtoToEntity(dto, entity);
		entity = repository.insert(entity);
		return new UsuarioDTO(entity);
	}

	private void copiaDtoToEntity(UsuarioDTO dto, Usuario entity) {
		entity.setNome(dto.getNome());
		entity.setEmail(dto.getEmail());
		entity.setSenha(dto.getSenha());
		entity.setPerfil(dto.getPerfil());		
	}
	
}
