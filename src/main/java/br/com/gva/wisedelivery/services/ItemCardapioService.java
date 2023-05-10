package br.com.gva.wisedelivery.services;

import br.com.gva.wisedelivery.domain.ItemCardapio;
import br.com.gva.wisedelivery.domain.dtos.restaurante.ItemCardapioDTO;

import java.util.Optional;

public interface ItemCardapioService {

    Optional<ItemCardapio> salvar(ItemCardapioDTO dto);
}
