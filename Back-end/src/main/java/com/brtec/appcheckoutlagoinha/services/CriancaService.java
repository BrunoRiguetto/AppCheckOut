package com.brtec.appcheckoutlagoinha.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brtec.appcheckoutlagoinha.models.dto.CriancaDTO;
import com.brtec.appcheckoutlagoinha.models.entities.Crianca;
import com.brtec.appcheckoutlagoinha.repositories.CriancaRepository;
import com.brtec.appcheckoutlagoinha.services.exceptions.ResourceNotFoundException;

@Service
public class CriancaService {

	@Autowired
	private CriancaRepository repository;
	
	
	public List<CriancaDTO> buscarTodas() {
		List<Crianca> lista = repository.findAll();
		
		return lista.stream().map(x -> new CriancaDTO(x)).collect(Collectors.toList());
	}
	
	public CriancaDTO buscarPorId(String id) {
		Crianca entity = getEntityById(id);
		
		return new CriancaDTO(entity);
	}
	
	public CriancaDTO inserir(CriancaDTO dto) {
		Crianca entity = new Crianca();
		copiaDtoToEntity(dto, entity);
		entity = repository.insert(entity);
		
		return new CriancaDTO(entity);
	}
	
	public CriancaDTO atualizar(String id, CriancaDTO dto) {
		Crianca entity = getEntityById(id);
		copiaDtoToEntity(dto, entity);
		entity = repository.save(entity);
		
		return new CriancaDTO(entity);
	}
	
	public void deletar(String id) {
		getEntityById(id);
		repository.deleteById(id);
	}
	
	private Crianca getEntityById(String id) {
		Optional<Crianca> resultado = repository.findById(id);
		
		return resultado.orElseThrow(() -> new ResourceNotFoundException("Criança não encontrada")); 
	}
	
	private void copiaDtoToEntity(CriancaDTO dto, Crianca entity) {
		entity.setNomeCompleto(dto.getNomeCompleto());
		entity.setDataNascimento(dto.getDataNascimento());
		entity.setSexo(dto.getSexo());
		entity.setNomeResponsavel(dto.getNomeResponsavel());		
	}
}
