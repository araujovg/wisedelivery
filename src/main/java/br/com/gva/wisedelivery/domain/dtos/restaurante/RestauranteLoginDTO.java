package br.com.gva.wisedelivery.domain.dtos.restaurante;

import lombok.Data;

@Data
public class RestauranteLoginDTO{

    private String email;
    private String senha;
    private String token;
    private boolean logado;

}