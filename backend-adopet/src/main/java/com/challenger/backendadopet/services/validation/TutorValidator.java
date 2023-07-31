package com.challenger.backendadopet.services.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.challenger.backendadopet.controllers.exceptions.FieldMessage;
import com.challenger.backendadopet.dtos.requesties.TutorRequest;
import com.challenger.backendadopet.entities.Tutor;
import com.challenger.backendadopet.repositories.TutorRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TutorValidator implements ConstraintValidator<TutorValid, TutorRequest> {

	@Autowired
	private TutorRepository repository;
	
	@Override
	public void initialize(TutorValid ann) {
	}
	
	@Override
	public boolean isValid(TutorRequest dto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		Tutor email = repository.findByEmail(dto.getEmail());
		if (email != null) {
			list.add(new FieldMessage("email", "Email já existe"));
		}
		
		Tutor cpf = repository.findByCpf(dto.getCpf());
		if (cpf != null) {
			list.add(new FieldMessage("cpf", "CPF já existe"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
