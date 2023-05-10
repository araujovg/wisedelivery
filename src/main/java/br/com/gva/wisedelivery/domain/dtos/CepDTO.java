package br.com.gva.wisedelivery.domain.dtos;

import lombok.Data;

@Data
public class CepDTO {

    private String cep;
    private String state;
    private String city;
    private String neighborhood;
    private String street;
    private LocationDTO location;
}