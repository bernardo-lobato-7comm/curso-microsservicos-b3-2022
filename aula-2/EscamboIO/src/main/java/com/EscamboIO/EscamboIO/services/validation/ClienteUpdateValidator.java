package com.EscamboIO.EscamboIO.services.validation;

import com.EscamboIO.EscamboIO.controller.exceptions.FieldMessage;
import com.EscamboIO.EscamboIO.domain.Cliente;
import com.EscamboIO.EscamboIO.domain.DTO.ClienteDTOUpdate;
import com.EscamboIO.EscamboIO.repositories.ClienteRepository;
import com.EscamboIO.EscamboIO.services.AuthService;
import com.EscamboIO.EscamboIO.services.validation.util.BR;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;


public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdateValid, ClienteDTOUpdate> {


    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AuthService authService;

    @Override
    public void initialize(ClienteUpdateValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(ClienteDTOUpdate clienteDTOUpdate, ConstraintValidatorContext constraintValidatorContext) {
        List<FieldMessage> list = new ArrayList<>();
        String username = authService.authenticatedCliente();

        Cliente cliente = clienteRepository.findByEmail(clienteDTOUpdate.getEmail());

        if (cliente != null && !cliente.getEmail().equals(username)) {
            list.add(new FieldMessage("Email", "Email já em uso"));
        }

        if (!BR.isValidCPF(clienteDTOUpdate.getCPF())) {
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

