package br.com.gva.wisedelivery.services.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gva.wisedelivery.domain.ItemCardapio;
import br.com.gva.wisedelivery.domain.Restaurante;
import br.com.gva.wisedelivery.domain.dtos.restaurante.ItemCardapioDTO;
import br.com.gva.wisedelivery.domain.dtos.restaurante.ItemCardapioSalvoDTO;
import br.com.gva.wisedelivery.repository.ItemCardapioRepository;
import br.com.gva.wisedelivery.services.ItemCardapioService;
import br.com.gva.wisedelivery.services.RestauranteService;

@Service
public class ItemCardapioServiceImpl implements ItemCardapioService {

    @Autowired
    private ItemCardapioRepository itemCardapioRepository;

    @Autowired
    private RestauranteService restauranteService;

    @Override
    public ItemCardapioSalvoDTO salvar(ItemCardapioDTO dto) {
        return deItemCardapioParaItemCardapioSalvoDto(itemCardapioRepository.save(deDtoParaItemCardapio(dto)));
    }

    private ItemCardapio deDtoParaItemCardapio(ItemCardapioDTO dto) {
        ItemCardapio itemCardapio = new ItemCardapio();
        BeanUtils.copyProperties(dto, itemCardapio);
        itemCardapio.setRestaurante(getRestaurante(dto.getRestauranteId()));
        return itemCardapio;
    }

    private ItemCardapioSalvoDTO deItemCardapioParaItemCardapioSalvoDto(ItemCardapio itemCardapio) {
        ItemCardapioSalvoDTO itemCardapioSalvoDTO = new ItemCardapioSalvoDTO();
        BeanUtils.copyProperties(itemCardapio, itemCardapioSalvoDTO);
        return itemCardapioSalvoDTO;
    }

    private ItemCardapioDTO deItemCardapioParaItemCardapioDto(ItemCardapio itemCardapio) {
        ItemCardapioDTO itemCardapioDTO = new ItemCardapioDTO();
        BeanUtils.copyProperties(itemCardapio, itemCardapioDTO);
        return itemCardapioDTO;
    }

    @Override
    public List<ItemCardapioDTO> todosOsItens(Long restauranteId) {
        return itemCardapioRepository.findAllByRestauranteId(restauranteId).stream().map(item -> deItemCardapioParaItemCardapioDto(item)).toList();
    }

    public Restaurante getRestaurante(Long restauranteId) {
        return restauranteService.procurarPeloId(restauranteId);
    }
}
