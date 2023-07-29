package com.challenger.backendadopet.dtos.responses;

import com.challenger.backendadopet.dtos.requesties.TutorRequest;
import com.challenger.backendadopet.entities.Tutor;

public class TutorResponse {

	 private String name;
	 private String email;
	 
	 public TutorResponse() {
	 }
	 	 
	 public TutorResponse(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TutorResponse convert(Tutor tutor) {
		 TutorResponse response = new TutorResponse();
		 response.setName(tutor.getName());
		 response.setEmail(tutor.getEmail());
		 return response;
	 }
	
	public TutorResponse convertDTOS(TutorRequest request) {
		 TutorResponse response = new TutorResponse();
		 response.setName(request.getName());
		 response.setEmail(request.getEmail());
		 return response;
	 }
}
