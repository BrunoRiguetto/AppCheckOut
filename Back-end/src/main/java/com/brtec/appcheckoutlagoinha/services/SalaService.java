package com.brtec.appcheckoutlagoinha.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brtec.appcheckoutlagoinha.models.dto.SalaDTO;
import com.brtec.appcheckoutlagoinha.models.entities.Sala;
import com.brtec.appcheckoutlagoinha.repositories.SalaRepository;
import com.brtec.appcheckoutlagoinha.services.exceptions.ResourceNotFoundException;

@Service
public class SalaService {

	@Autowired
	private SalaRepository repository;

	public List<SalaDTO> buscarTodos() {
		List<Sala> lista = repository.findAll();

		return lista.stream().map(x -> new SalaDTO(x)).collect(Collectors.toList());
	}

	public SalaDTO buscarPorId(String id) {
		Sala entity = getEntityById(id);

		return new SalaDTO(entity);
	}

	public SalaDTO inserir(SalaDTO dto) {
		Sala entity = new Sala();
		copiaDtoToEntity(dto, entity);
		entity = repository.insert(entity);
		return new SalaDTO(entity);
	}

	public SalaDTO atualizar(String id, SalaDTO dto) {
		Sala entity = getEntityById(id);
		copiaDtoToEntity(dto, entity);
		entity = repository.save(entity);

		return new SalaDTO(entity);
	}

	public void deletar(String id) {
		getEntityById(id);
		repository.deleteById(id);
	}

	private void copiaDtoToEntity(SalaDTO dto, Sala entity) {
		entity.setNome(dto.getNome());
		entity.setDescricao(dto.getDescricao());
		entity.setIdadeInicial(dto.getIdadeInicial());
		entity.setIdadeFinal(dto.getIdadeFinal());
	}

	private Sala getEntityById(String id) {
		Optional<Sala> resultado = repository.findById(id);
		return resultado.orElseThrow(() -> new ResourceNotFoundException("Sala não encontrada"));
	}

}
