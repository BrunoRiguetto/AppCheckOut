package com.brtec.appcheckoutlagoinha.models.embedded;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;

import com.brtec.appcheckoutlagoinha.models.entities.Crianca;
import com.brtec.appcheckoutlagoinha.models.entities.Sala;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CheckOut {

	@Id
	private UUID id;
	private Sala sala;
	
	private List<Crianca> criancas = new ArrayList<>();
	
	public CheckOut(UUID id, Sala sala) {
		this.id = id;
		this.sala = sala;
	}	
}
