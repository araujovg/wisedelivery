package br.com.gva.wisedelivery.domain.dtos.cliente;

import lombok.Data;

@Data
public class ClienteLoginDTO {

    private String email;
    private String senha;

}