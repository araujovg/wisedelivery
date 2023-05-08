package br.com.gva.wisedelivery.controller.validator.impl.cliente;

import org.springframework.stereotype.Component;

import br.com.gva.wisedelivery.controller.validator.ConfirmaSenhaValidator;
import br.com.gva.wisedelivery.domain.dtos.cliente.ClienteDTO;

@Component
public class ConfirmaSenhaValidatorImpl implements ConfirmaSenhaValidator {

    @Override
    public boolean validator(ClienteDTO cliente) {
        return !cliente.getSenha().equals(cliente.getConfirmaSenha());
    }

    
}