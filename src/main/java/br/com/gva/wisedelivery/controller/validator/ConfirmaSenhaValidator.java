package br.com.gva.wisedelivery.controller.validator;

import br.com.gva.wisedelivery.domain.dtos.ClienteDTO;

public interface ConfirmaSenhaValidator {
    boolean confirmaSenhaValidator(ClienteDTO cliente);
}