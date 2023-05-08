package br.com.gva.wisedelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gva.wisedelivery.domain.Restaurante;
import br.com.gva.wisedelivery.domain.dtos.restaurante.RestauranteDTO;
import br.com.gva.wisedelivery.repository.CategoriaRestauranteRepository;
import br.com.gva.wisedelivery.services.RestauranteService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @Autowired
    private CategoriaRestauranteRepository categoriaRestauranteRepository;

    @GetMapping("home")
    public String formCadastroRestaurante(Model model){
        var lista = categoriaRestauranteRepository.findAll();
        model.addAttribute("categorias", lista);
        model.addAttribute("restaurante", new RestauranteDTO());
        return "restaurante-cadastro";
    }

    @PostMapping("save")
    public String salvarRestaurante(@ModelAttribute("restaurante") @Valid RestauranteDTO restauranteDTO) {
        restauranteService.salvar(restauranteDTO);
        return "restaurante-cadastro";
    }

    @GetMapping("categorias")
    public void pegaCategorias(Model model){
        var lista = categoriaRestauranteRepository.findAll();
        model.addAttribute("categorias", lista);
    }
    
}