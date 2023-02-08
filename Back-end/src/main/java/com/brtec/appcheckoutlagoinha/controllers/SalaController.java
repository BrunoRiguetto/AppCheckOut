package com.brtec.appcheckoutlagoinha.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.brtec.appcheckoutlagoinha.models.dto.SalaDTO;
import com.brtec.appcheckoutlagoinha.services.SalaService;

@RestController
@RequestMapping("/api/v1/salas")
public class SalaController {

		@Autowired
		private SalaService service;
		
		@GetMapping
		public ResponseEntity<List<SalaDTO>> buscarTodas(){
			List<SalaDTO> list = service.buscarTodos();
			
			return ResponseEntity.ok().body(list); 
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<SalaDTO> buscarPorId(@PathVariable String id){
			SalaDTO obj = service.buscarPorId(id);
			
			return ResponseEntity.ok().body(obj); 
		}
		
		@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public SalaDTO inserir(@RequestBody SalaDTO sala){
			
			return service.inserir(sala);
		}
		
		@PutMapping("/{id}")
		@ResponseStatus(HttpStatus.OK)
		public SalaDTO atualizar(@PathVariable String id, @RequestBody SalaDTO sala) {
			
			return service.atualizar(id, sala);
		}
		
		@DeleteMapping("/{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void deletar(@PathVariable String id) {
			service.deletar(id);
		}
	}