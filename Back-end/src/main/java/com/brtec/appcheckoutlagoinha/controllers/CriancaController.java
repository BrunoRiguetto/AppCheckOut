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

import com.brtec.appcheckoutlagoinha.models.dto.CriancaDTO;
import com.brtec.appcheckoutlagoinha.services.CriancaService;

@RestController
@RequestMapping("/api/v1/criancas")
public class CriancaController {

	@Autowired
	private CriancaService service;
	
	@GetMapping
	public ResponseEntity<List<CriancaDTO>> buscarTodas(){
		List<CriancaDTO> lista = service.buscarTodas();
		
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CriancaDTO> buscarPorId(@PathVariable String id){
		CriancaDTO crianca = service.buscarPorId(id);
		
		return ResponseEntity.ok(crianca);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CriancaDTO inserir(@RequestBody CriancaDTO crianca) {
		
		return service.inserir(crianca);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public CriancaDTO atualizar(@PathVariable String id, @RequestBody CriancaDTO crianca) {
		
		return service.atualizar(id, crianca);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable String id) {
		service.deletar(id);
	}
	
}
