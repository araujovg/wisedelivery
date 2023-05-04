package br.com.gva.wisedelivery.services;

import br.com.gva.wisedelivery.domain.dtos.ClienteDTO;
import br.com.gva.wisedelivery.domain.dtos.ClienteSalvoDTO;

public interface ClienteService {
    
    ClienteSalvoDTO salvar(ClienteDTO dto);
}