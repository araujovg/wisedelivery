package br.com.gva.wisedelivery.services.impl;

import java.io.IOException;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gva.wisedelivery.domain.Restaurante;
import br.com.gva.wisedelivery.domain.dtos.restaurante.RestauranteDTO;
import br.com.gva.wisedelivery.domain.dtos.restaurante.RestauranteSalvoDTO;
import br.com.gva.wisedelivery.repository.RestauranteRepository;
import br.com.gva.wisedelivery.services.RestauranteService;
import lombok.Getter;

@Service
public class RestauranteServiceImpl implements RestauranteService{

    @Autowired
    @Getter
    private RestauranteRepository restauranteRepository;

    @Autowired
    @Getter
    private ImageService imageService;

    @Override
    public RestauranteSalvoDTO salvar(RestauranteDTO dto) throws IOException {
        if(Objects.isNull(dto.getLogotipo()) || Objects.nonNull(dto.getArquivoLogotipo())){
            dto.setLogotipo(getImageService().uploadImage(dto.getArquivoLogotipo()));
        }
        return deRestauranteParaRestauranteSalvoDto(
            getRestauranteRepository().save(
                    deDtoParaRestaurante(dto)));
    }

    private Restaurante deDtoParaRestaurante(RestauranteDTO dto) {
        Restaurante restaurante = new Restaurante();
        BeanUtils.copyProperties(dto, restaurante, "confirmaSenha");
        return restaurante;
    }

    private RestauranteSalvoDTO deRestauranteParaRestauranteSalvoDto(Restaurante restaurante) {
        RestauranteSalvoDTO restauranteSalvoDTO = new RestauranteSalvoDTO();
        BeanUtils.copyProperties(restaurante, restauranteSalvoDTO, "senha", "confirmaSenha");
        return restauranteSalvoDTO;
    }
    
}