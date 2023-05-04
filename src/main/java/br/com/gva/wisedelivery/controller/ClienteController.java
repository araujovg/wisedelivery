package br.com.gva.wisedelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gva.wisedelivery.domain.Cliente;
import br.com.gva.wisedelivery.domain.dtos.ClienteInserirDTO;

@Controller
@RequestMapping("clientes")
public class ClienteController {

    @GetMapping("form-cadastro")
    public String formCliente(Model model){
        model.addAttribute("clientes", new Cliente());
        return "cliente-cadastro";
    }

    @PostMapping("/novo")
    public String salvarCLiente(@ModelAttribute("cliente") ClienteInserirDTO cliente){
        
        return "home-cliente";
    }
    
}
