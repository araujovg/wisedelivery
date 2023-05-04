package br.com.gva.wisedelivery.services.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gva.wisedelivery.domain.Cliente;
import br.com.gva.wisedelivery.domain.dtos.ClienteDTO;
import br.com.gva.wisedelivery.domain.dtos.ClienteSalvoDTO;
import br.com.gva.wisedelivery.repository.ClienteRepository;
import br.com.gva.wisedelivery.services.ClienteService;
import lombok.Getter;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    @Getter private ClienteRepository clienteRepository;

    @Override
    public ClienteSalvoDTO salvar(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        ClienteSalvoDTO clienteSalvoDTO = new ClienteSalvoDTO();

        BeanUtils.copyProperties(dto, cliente, "confirmaSenha");
        getClienteRepository().save(cliente);
        BeanUtils.copyProperties(cliente, clienteSalvoDTO, "senha", "confirmaSenha");
        
        return clienteSalvoDTO;
        
    }
    
}