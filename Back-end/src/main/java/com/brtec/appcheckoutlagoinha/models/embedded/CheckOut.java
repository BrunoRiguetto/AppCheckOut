package com.brtec.appcheckoutlagoinha.models.embedded;

import java.util.ArrayList;
import java.util.List;

import com.brtec.appcheckoutlagoinha.models.entities.Crianca;
import com.brtec.appcheckoutlagoinha.models.entities.Sala;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CheckOut {

	private Sala sala;
	
	private List<Crianca> criancas = new ArrayList<>();
	
	public CheckOut(Sala sala) {
		this.sala = sala;
	}	
}
