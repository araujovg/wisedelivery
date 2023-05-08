package br.com.gva.wisedelivery.services;

import br.com.gva.wisedelivery.domain.dtos.cliente.ClienteDTO;
import br.com.gva.wisedelivery.domain.dtos.cliente.ClienteLoginDTO;
import br.com.gva.wisedelivery.domain.dtos.cliente.ClienteSalvoDTO;

public interface ClienteService {
    
    ClienteSalvoDTO salvar(ClienteDTO dto);

    boolean login(ClienteLoginDTO cliente);
}