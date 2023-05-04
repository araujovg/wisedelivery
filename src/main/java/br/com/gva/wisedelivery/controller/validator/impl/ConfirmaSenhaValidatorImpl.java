package br.com.gva.wisedelivery.controller.validator.impl;

import org.springframework.stereotype.Component;

import br.com.gva.wisedelivery.controller.validator.ConfirmaSenhaValidator;
import br.com.gva.wisedelivery.domain.dtos.ClienteDTO;

@Component
public class ConfirmaSenhaValidatorImpl implements ConfirmaSenhaValidator {

    @Override
    public boolean confirmaSenhaValidator(ClienteDTO cliente) {
        return !cliente.getSenha().equals(cliente.getConfirmaSenha());
    }
    
}