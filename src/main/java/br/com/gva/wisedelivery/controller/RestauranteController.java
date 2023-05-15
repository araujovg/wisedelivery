package br.com.gva.wisedelivery.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gva.wisedelivery.domain.dtos.restaurante.RestauranteDTO;
import br.com.gva.wisedelivery.domain.dtos.restaurante.RestauranteLoginDTO;
import br.com.gva.wisedelivery.repository.CategoriaRestauranteRepository;
import br.com.gva.wisedelivery.services.RestauranteService;
import br.com.gva.wisedelivery.utils.ServiceUtils;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
 @Log4j2
 @Controller
@RequestMapping("restaurantes")
public class RestauranteController {

    @Autowired @Getter
    private RestauranteService restauranteService;

    @Autowired @Getter
    private CategoriaRestauranteRepository categoriaRestauranteRepository;

    @Autowired @Getter
    private ServiceUtils utils;

    @GetMapping("login")
    public String telaLogin(Model model){
        model.addAttribute("restaurante", new RestauranteLoginDTO());
        return "login-restaurante";
    }

    @PostMapping("logar")
    public String login(@ModelAttribute("restaurante") RestauranteLoginDTO restaurante, Model model){
        if(!getRestauranteService().login(restaurante)) {
            return "login";
        }
        var restauranteDTO = getRestauranteService().procurarPeloEmail(restaurante.getEmail());
        log.info("RESTAURANTE ID: " + restauranteDTO.getId());
        model.addAttribute("restauranteId", restauranteDTO.getId());
        //Ajuste técnico para não retornar a senha salva para o dashboard
        restaurante.setLogado(true);
        restaurante.setToken(getUtils().getToken());
        restaurante.setSenha(null);
        return home(model);
    }

    @GetMapping("form-cadastro")
    public String formCadastroRestaurante(Model model){
        var lista = categoriaRestauranteRepository.findAll();
        model.addAttribute("categorias", lista);
        model.addAttribute("restaurante", new RestauranteDTO());
        return "restaurante-cadastro";
    }

    @PostMapping("save")
    public String salvarRestaurante(@ModelAttribute("restaurante") @Valid RestauranteDTO restauranteDTO) throws IOException {
        restauranteService.salvar(restauranteDTO);
        return "redirect:/restaurantes/home";
    }

    @GetMapping("categorias")
    public void pegaCategorias(Model model){
        var lista = categoriaRestauranteRepository.findAll();
        model.addAttribute("categorias", lista);
    }

    @GetMapping("admin/restaurante-dashboard")
    public String home(Model model){
        return "restaurante-dashboard";
    }

}