package br.com.gva.wisedelivery.controller;

import java.io.IOException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gva.wisedelivery.domain.dtos.restaurante.ItemCardapioDTO;
import br.com.gva.wisedelivery.domain.dtos.restaurante.RestauranteDTO;
import br.com.gva.wisedelivery.domain.dtos.restaurante.RestauranteLoginDTO;
import br.com.gva.wisedelivery.domain.dtos.restaurante.RestauranteSalvoDTO;
import br.com.gva.wisedelivery.repository.CategoriaRestauranteRepository;
import br.com.gva.wisedelivery.services.RestauranteService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
 @Log4j2
 @Controller
@RequestMapping("restaurantes")
public class RestauranteController {

    @Autowired @Getter
    private RestauranteService restauranteService;

    @Autowired
    private CategoriaRestauranteRepository categoriaRestauranteRepository;

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
        return home(model, restaurante.getEmail());
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

    @GetMapping("admin/dashboard")
    public String home(Model model, String restauranteEmail){
        log.info("RESTAURANTE: " + model.getAttribute("restaurante"));
        model.addAttribute("emailRestaurante", model.getAttribute("restaurante"));
        return "restaurante-dashboard";
    }

    @GetMapping("admin/dashboard/form-itemcardapio")
    public String formItemCardapio(Model model){
        Object attribute = model.getAttribute("restaurante");
        if(Objects.nonNull(attribute)) {
            String emailRestaurante = (String) attribute;
            RestauranteSalvoDTO restaurante =  getRestauranteService().procurarPeloEmail(emailRestaurante);
            model.addAttribute("restaurante", restaurante.getId());
            model.addAttribute("itemCardapio", new ItemCardapioDTO());
            log.info("RESTAURANTE: " + restaurante.getId());
            return "restaurante-dashboard-cadastro-itens-cardapio";
        } else {
            log.error("NULLLLLOOOOOOOOOOOOOOOOOOOO");
        }
        return "restaurante-dashboard";
    }

}