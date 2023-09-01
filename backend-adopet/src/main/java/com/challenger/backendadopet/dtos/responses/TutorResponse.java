package com.challenger.backendadopet.dtos.responses;

import com.challenger.backendadopet.entities.Tutor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class TutorResponse {

	 private String name;
	 private String email;

	public TutorResponse convert(Tutor tutor) {
		 TutorResponse response = new TutorResponse();
		 response.setName(tutor.getName());
		 response.setEmail(tutor.getEmail());
		 return response;
	}
}
