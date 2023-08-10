package com.challenger.backendadopet.services.validation;

import com.challenger.backendadopet.controllers.exceptions.FieldMessage;
import com.challenger.backendadopet.dtos.requesties.ShelterRequest;
import com.challenger.backendadopet.entities.Shelter;
import com.challenger.backendadopet.repositories.ShelterRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ShelterValidator implements ConstraintValidator<ShelterValid, ShelterRequest> {

	@Autowired
	private ShelterRepository repository;
	
	@Override
	public void initialize(ShelterValid ann) {
	}
	
	@Override
	public boolean isValid(ShelterRequest dto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		Shelter email = repository.findByEmail(dto.getEmail());
		if (email != null) {
			list.add(new FieldMessage("email", "Email já existe"));
		}
		
		Shelter cnpj = repository.findByCnpj(dto.getCnpj());
		if (cnpj != null) {
			list.add(new FieldMessage("cnpj", "CNPJ já existe"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
