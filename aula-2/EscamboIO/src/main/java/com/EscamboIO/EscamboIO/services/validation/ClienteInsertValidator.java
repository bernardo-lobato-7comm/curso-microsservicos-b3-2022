package com.EscamboIO.EscamboIO.services.validation;

import com.EscamboIO.EscamboIO.controller.exceptions.FieldMessage;
import com.EscamboIO.EscamboIO.domain.Cliente;
import com.EscamboIO.EscamboIO.domain.DTO.ClienteDTOInsert;
import com.EscamboIO.EscamboIO.repositories.ClienteRepository;
import com.EscamboIO.EscamboIO.services.validation.util.BR;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsertValid, ClienteDTOInsert> {


    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public void initialize(ClienteInsertValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(ClienteDTOInsert clienteDTOInsert, ConstraintValidatorContext constraintValidatorContext) {
        List<FieldMessage> list = new ArrayList<>();

        Cliente cliente = clienteRepository.findByEmail(clienteDTOInsert.getEmail());

        if (cliente != null){
            list.add(new FieldMessage("Email", "Email já existe"));
        }

        if(!BR.isValidCPF(clienteDTOInsert.getCPF())){
            list.add(new FieldMessage("CPF", "CPF inválido"));
        }

        for (FieldMessage e : list) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}
