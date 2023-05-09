package br.com.gva.wisedelivery.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
import br.com.gva.wisedelivery.services.ImageService;
import br.com.gva.wisedelivery.services.RestauranteService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("restaurantes")
public class RestauranteController {

    public static final String PASTA_DE_UPLOAD = System.getProperty("user.dir") + "/uploads";

    @Autowired
    private RestauranteService restauranteService;

    @Autowired
    private CategoriaRestauranteRepository categoriaRestauranteRepository;

    @Autowired
    private ImageService imageService;

    @GetMapping("home")
    public String formCadastroRestaurante(Model model){
        var lista = categoriaRestauranteRepository.findAll();
        model.addAttribute("categorias", lista);
        model.addAttribute("restaurante", new RestauranteDTO());
        return "restaurante-cadastro";
    }

    @PostMapping("save")
    public String salvarRestaurante(@ModelAttribute("restaurante") @Valid RestauranteDTO restauranteDTO) throws IOException {
        StringBuilder fileNames = new StringBuilder();
        Path nomeArquivoECaminho = Paths.get(PASTA_DE_UPLOAD, restauranteDTO.getArquivoLogotipo().getOriginalFilename());
        
        Files.write(nomeArquivoECaminho, restauranteDTO.getArquivoLogotipo().getBytes());
        fileNames.append(nomeArquivoECaminho);
        fileNames.append(restauranteDTO.getArquivoLogotipo().getBytes());
        System.out.println("Uploaded images: " + fileNames.toString());
        var restaurante = restauranteService.salvar(restauranteDTO);
        //restauranteDTO.set
        //restauranteDTO.setLogotipoFileName();
        //imageService.uploadLogotipo(restauranteDTO.getLogotipoFile(), restauranteDTO.getLogotipo());
        return "restaurante-cadastro";
    }

    @GetMapping("categorias")
    public void pegaCategorias(Model model){
        var lista = categoriaRestauranteRepository.findAll();
        model.addAttribute("categorias", lista);
    }
    
}