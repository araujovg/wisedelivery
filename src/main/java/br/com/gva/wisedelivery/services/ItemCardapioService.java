package br.com.gva.wisedelivery.services;

import java.util.Optional;

import br.com.gva.wisedelivery.domain.ItemCardapio;
import br.com.gva.wisedelivery.domain.dtos.restaurante.ItemCardapioDTO;

public interface ItemCardapioService {

    Optional<ItemCardapio> salvar(ItemCardapioDTO dto);
}
