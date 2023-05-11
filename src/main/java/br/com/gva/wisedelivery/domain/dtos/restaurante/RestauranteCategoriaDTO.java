package br.com.gva.wisedelivery.domain.dtos.restaurante;

import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import br.com.gva.wisedelivery.domain.Restaurante;
import lombok.Data;

@Data
public class RestauranteCategoriaDTO {
    private Integer id;
    private String nome;
    private String imagem;
    private MultipartFile multipartFile;
    private Set<Restaurante> restaurantes;
}