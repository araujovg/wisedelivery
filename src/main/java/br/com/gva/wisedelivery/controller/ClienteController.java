package br.com.gva.wisedelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gva.wisedelivery.controller.validator.ConfirmaSenhaValidator;
import br.com.gva.wisedelivery.domain.dtos.ClienteDTO;
import br.com.gva.wisedelivery.exception.SenhaInvalidaException;
import br.com.gva.wisedelivery.services.ClienteService;
import lombok.Getter;

@Controller
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    @Getter private ClienteService clienteService;

    @Autowired
    @Getter private ConfirmaSenhaValidator validator;

    @GetMapping("form-cadastro")
    public String formCliente(Model model){
        model.addAttribute("cliente", new ClienteDTO());
        return "cliente-cadastro";
    }

    @PostMapping("/novo")
    public String salvarCLiente(@ModelAttribute("cliente") ClienteDTO cliente){
        if(validator.confirmaSenhaValidator(cliente)) {
            throw new SenhaInvalidaException("Senha e confirmação de senha não coincidem");
        }
        System.out.println(getClienteService().salvar(cliente));
        return "home-cliente";
    }
    
}
