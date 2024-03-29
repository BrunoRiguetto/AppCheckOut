package com.brtec.appcheckoutlagoinha.config;

import java.time.Instant;
import java.util.Arrays;

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
				
		Usuario usuario1 = new Usuario(null, "José da Silva", "josedasilva@email.com", "123456", Perfil.ADMIN);
			
		Sala de3a6anos = new Sala(null, "3 a 6 anos", null, 3, 6);
		Sala de7a9anos = new Sala(null, "7 a 9 anos", null, 7, 9);
		Sala de3a12anos = new Sala(null, "3 a 12 anos", null, 3, 12);	
				
		Crianca pedro = new Crianca(null, "Pedro Riguetto", Instant.parse("2019-10-06T11:15:01Z"), Sexo.MASCULINO, "Bruno Riguetto");
		Crianca debora = new Crianca(null, "Debora Marcelino", Instant.parse("2022-05-30T11:15:01Z"), Sexo.FEMININO, "Sabrina Marcelino");
		Crianca joao = new Crianca(null, "Joao de Oliveira", Instant.parse("2015-04-20T11:15:01Z"), Sexo.MASCULINO, "Maria de Oliveira");
		Crianca augusto = new Crianca(null, "Augusto Camargo", Instant.parse("2016-08-10T11:15:01Z"), Sexo.MASCULINO, "Roseli Neves");
		
		pedro.getSalas().addAll(Arrays.asList(de3a6anos, de3a12anos));
		debora.getSalas().addAll(Arrays.asList(de3a6anos, de3a12anos));
		joao.getSalas().addAll(Arrays.asList(de7a9anos, de3a12anos));
		augusto.getSalas().addAll(Arrays.asList(de7a9anos, de3a12anos));
		
		CheckOut checkOut1 = new CheckOut(de3a6anos);
		CheckOut checkOut2 = new CheckOut(de7a9anos);
		
		checkOut1.getCriancas().addAll(Arrays.asList(pedro, debora));
		checkOut2.getCriancas().addAll(Arrays.asList(joao, augusto));
		
		checkOutRepository.saveAll(Arrays.asList(checkOut1, checkOut2));
		usuarioRepository.save(usuario1);
		salaRepository.saveAll(Arrays.asList(de3a6anos, de7a9anos, de3a12anos));
		criancaRepository.saveAll(Arrays.asList(pedro, debora, joao, augusto));
	}
	
}
