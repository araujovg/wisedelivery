package br.com.gva.wisedelivery.services.impl;

import br.com.gva.wisedelivery.domain.ItemCardapio;
import br.com.gva.wisedelivery.domain.dtos.restaurante.ItemCardapioDTO;
import br.com.gva.wisedelivery.repository.ItemCardapioRepository;
import br.com.gva.wisedelivery.services.ItemCardapioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemCardapioServiceImpl implements ItemCardapioService {

    @Autowired
    private ItemCardapioRepository itemCardapioRepository;

    @Override
    public Optional<ItemCardapio> salvar(ItemCardapioDTO dto) {
        return Optional.empty();
    }
}
