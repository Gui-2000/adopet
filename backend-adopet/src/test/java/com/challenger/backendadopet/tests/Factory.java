package com.challenger.backendadopet.tests;

import com.challenger.backendadopet.dtos.responses.TutorResponse;
import com.challenger.backendadopet.entities.Tutor;

public class Factory {
		
	public static Tutor createdTutor() {
		Tutor tutor = new Tutor(1L, "Jean Santos", "jeancbsan@email.com", "98709764","000000000-01","Rua Sete de Maio, S/N Vila Madalena","Sorocoba","SP","12-699667738","www.imagem-1.com.br");
		return tutor;
	}
	public static TutorResponse createdTutorResponse() {
		Tutor tutor = createdTutor();
		TutorResponse response = new TutorResponse();
		response.setName(tutor.getName());
		response.setEmail(tutor.getEmail());
		return response;
	}
}
