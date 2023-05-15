package br.com.gva.wisedelivery.services;

import java.util.List;

import br.com.gva.wisedelivery.domain.dtos.restaurante.ItemCardapioDTO;
import br.com.gva.wisedelivery.domain.dtos.restaurante.ItemCardapioSalvoDTO;

public interface ItemCardapioService {

    ItemCardapioSalvoDTO salvar(ItemCardapioDTO dto);

    List<ItemCardapioDTO> todosOsItens(Long restauranteId);
}
