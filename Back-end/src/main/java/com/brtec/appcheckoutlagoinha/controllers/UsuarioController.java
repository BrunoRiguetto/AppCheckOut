package com.brtec.appcheckoutlagoinha.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brtec.appcheckoutlagoinha.models.dto.UsuarioDTO;
import com.brtec.appcheckoutlagoinha.services.UsuarioService;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> buscarTodos(){
		List<UsuarioDTO> list = service.buscarTodos();
		
		return ResponseEntity.ok().body(list); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable UUID id){
		UsuarioDTO obj = service.buscarPorId(id);
		
		return ResponseEntity.ok().body(obj); 
	}
}
