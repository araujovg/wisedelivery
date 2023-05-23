package br.com.gva.wisedelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gva.wisedelivery.domain.dtos.restaurante.ItemCardapioDTO;
import br.com.gva.wisedelivery.services.ItemCardapioService;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("admin/itens-cardapio")
public class ItemCardapioController {

    @Autowired @Getter
    private ItemCardapioService itemCardapioService;

    @GetMapping("form-itemcardapio")
    public String formItemCardapio(Model model){
        model.addAttribute("itemCardapio", new ItemCardapioDTO());
        return "restaurante-dashboard-itemcardapio-form";
    }

    @PostMapping("save")
    public String salvarItemCardapio(@ModelAttribute("item") ItemCardapioDTO dto, Model model) {
        getItemCardapioService().salvar(dto);
        log.info("Lista: " + getItemCardapioService().todosOsItens(dto.getRestauranteId()));
        model.addAttribute("itens", getItemCardapioService().todosOsItens(dto.getRestauranteId()));
        return formItemCardapio(model);
    }

    @GetMapping("{restauranteId}")
    public String listarItensPorRestaurante(Model model, Long restaurantId) {
        getItemCardapioService().
        return null;
    }

}