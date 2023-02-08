package com.brtec.appcheckoutlagoinha.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.brtec.appcheckoutlagoinha.models.dto.SalaDTO;
import com.brtec.appcheckoutlagoinha.models.entities.Sala;
import com.brtec.appcheckoutlagoinha.repositories.SalaRepository;
import com.brtec.appcheckoutlagoinha.services.exceptions.ResourceNotFoundException;

public class SalaService {

	@Autowired
	private SalaRepository repository;

	public List<SalaDTO> buscarTodos() {
		List<Sala> lista = repository.findAll();

		return lista.stream().map(x -> new SalaDTO(x)).collect(Collectors.toList());
	}

	public SalaDTO buscarPorId(String salaId) {
		Sala entity = getEntityById(salaId);

		return new SalaDTO(entity);
	}

	public SalaDTO inserir(SalaDTO dto) {
		Sala entity = new Sala();
		copiaDtoToEntity(dto, entity);
		entity = repository.insert(entity);
		return new SalaDTO(entity);
	}

	public SalaDTO atualizar(String salaId, SalaDTO dto) {
		Sala entity = getEntityById(salaId);
		copiaDtoToEntity(dto, entity);
		entity = repository.save(entity);

		return new SalaDTO(entity);
	}

	public void deletar(String salaId) {
		getEntityById(salaId);
		repository.deleteById(salaId);
	}

	private void copiaDtoToEntity(SalaDTO dto, Sala entity) {
		entity.setNome(dto.getNome());
		entity.setDescricao(dto.getDescricao());
		entity.setIdadeInicial(dto.getIdadeInicial());
		entity.setIdadeFinal(dto.getIdadeFinal());
	}

	private Sala getEntityById(String salaId) {
		Optional<Sala> resultado = repository.findById(salaId);
		return resultado.orElseThrow(() -> new ResourceNotFoundException("Sala não encontrado"));
	}

}
