package br.com.gva.wisedelivery.domain.dtos;

import lombok.Data;

@Data
public class LocationDTO {
    private String type;
    private CoordenadasDTO coordinates;

    @Data
    public class CoordenadasDTO {
        private String longitude;
        private String latitude;
    }
}

