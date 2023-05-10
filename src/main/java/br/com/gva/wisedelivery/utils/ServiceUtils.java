package br.com.gva.wisedelivery.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.gva.wisedelivery.domain.dtos.CepDTO;
import lombok.Getter;

@Service
public class ServiceUtils {

    @Getter
    @Value("${brasil.api.v2.cep.url}")
    private String apiUrl;

    public void consultaCep(String cep){
        apiUrl += cep;
        System.out.println("Request for: " + apiUrl); 
        RestTemplate restTemplate = new RestTemplate();
        var result = restTemplate.getForEntity(apiUrl, CepDTO.class);
        System.out.println("RESULTADO: " + result.getBody());
    }
    
}