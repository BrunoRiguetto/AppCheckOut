package com.brtec.appcheckoutlagoinha.config;

import java.time.Instant;
import java.util.Arrays;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.brtec.appcheckoutlagoinha.models.embedded.CheckOut;
import com.brtec.appcheckoutlagoinha.models.entities.Crianca;
import com.brtec.appcheckoutlagoinha.models.entities.Sala;
import com.brtec.appcheckoutlagoinha.models.entities.Usuario;
import com.brtec.appcheckoutlagoinha.models.entities.enuns.Perfil;
import com.brtec.appcheckoutlagoinha.models.entities.enuns.Sexo;
import com.brtec.appcheckoutlagoinha.repositories.CheckOutRepository;
import com.brtec.appcheckoutlagoinha.repositories.CriancaRepository;
import com.brtec.appcheckoutlagoinha.repositories.SalaRepository;
import com.brtec.appcheckoutlagoinha.repositories.UsuarioRepository;

import jakarta.annotation.PostConstruct;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private CriancaRepository criancaRepository;
	
	@Autowired
	private SalaRepository salaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private CheckOutRepository checkOutRepository;
	
	@PostConstruct
	public void init() {
		
		salaRepository.deleteAll();
		criancaRepository.deleteAll();
		usuarioRepository.deleteAll();
		checkOutRepository.deleteAll();
				
		Usuario usuario1 = new Usuario(UUID.randomUUID(), "José da Silva", "josedasilva@email.com", "123456", Perfil.ADMIN);

			
		Sala de3a6anos = new Sala(UUID.randomUUID(), "3 a 6 anos");
		Sala de7a9anos = new Sala(UUID.randomUUID(), "7 a 9 anos");
		Sala de3a12anos = new Sala(UUID.randomUUID(), "3 a 12 anos");	
				
		Crianca pedro = new Crianca(UUID.randomUUID(), "Pedro Riguetto", Instant.parse("2019-10-06T11:15:01Z"), Sexo.MASCULINO, "Bruno Riguetto");
		Crianca debora = new Crianca(UUID.randomUUID(), "Debora Marcelino", Instant.parse("2022-05-30T11:15:01Z"), Sexo.FEMININO, "Sabrina Marcelino");
		
		CheckOut checkOut1 = new CheckOut(UUID.randomUUID(), de3a6anos);
		
		checkOutRepository.save(checkOut1);
		usuarioRepository.save(usuario1);
		salaRepository.saveAll(Arrays.asList(de3a6anos, de7a9anos));
		criancaRepository.saveAll(Arrays.asList(pedro, debora));
	}
	
}
