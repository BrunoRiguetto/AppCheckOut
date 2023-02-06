package com.brtec.appcheckoutlagoinha.config;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.brtec.appcheckoutlagoinha.models.entities.Crianca;
import com.brtec.appcheckoutlagoinha.models.entities.Sala;
import com.brtec.appcheckoutlagoinha.models.entities.Sexo;
import com.brtec.appcheckoutlagoinha.repositories.CriancaRepository;
import com.brtec.appcheckoutlagoinha.repositories.SalaRepository;

import jakarta.annotation.PostConstruct;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private CriancaRepository criancaRepository;
	
	@Autowired
	private SalaRepository salaRepository;
	
	@PostConstruct
	public void init() {
		
		salaRepository.deleteAll();
		criancaRepository.deleteAll();
		
		Sala de3a6anos = new Sala(UUID.randomUUID(), "3 a 6 anos");
		Sala de7a9anos = new Sala(UUID.randomUUID(), "7 a 9 anos");
		Sala de3a12anos = new Sala(UUID.randomUUID(), "3 a 12 anos");
		
		List<Sala> salas = new ArrayList<>();
		salas.add(de3a6anos);
		salas.add(de3a12anos);
		
		List<Sala> sala = new ArrayList<>();
		sala.add(de3a6anos);
		
		Crianca pedro = new Crianca(UUID.randomUUID(), "Pedro Riguetto", Instant.parse("2019-10-06T11:15:01Z"), Sexo.MASCULINO, "Bruno Riguetto", salas);
		Crianca debora = new Crianca(UUID.randomUUID(), "Debora Marcelino", Instant.parse("2022-05-30T11:15:01Z"), Sexo.FEMININO, "Sabrina Marcelino",sala);
			
		salaRepository.saveAll(Arrays.asList(de3a6anos, de7a9anos));
		criancaRepository.saveAll(Arrays.asList(pedro, debora));
	}
	
}
