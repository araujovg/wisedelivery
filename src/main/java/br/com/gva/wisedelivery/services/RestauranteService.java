package br.com.gva.wisedelivery.services;

import java.io.IOException;

import br.com.gva.wisedelivery.domain.dtos.restaurante.RestauranteDTO;
import br.com.gva.wisedelivery.domain.dtos.restaurante.RestauranteSalvoDTO;

public interface RestauranteService {
    RestauranteSalvoDTO salvar(RestauranteDTO dto) throws IOException;
}