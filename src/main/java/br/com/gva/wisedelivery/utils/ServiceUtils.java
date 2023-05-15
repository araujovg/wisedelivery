package br.com.gva.wisedelivery.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.gva.wisedelivery.domain.dtos.CepDTO;
import lombok.Getter;

@Service
public class ServiceUtils {

    public ServiceUtils() throws NoSuchAlgorithmException{ /* TODO document why this constructor is empty */ }

    @Getter
    @Value("${brasil.api.v2.cep.url}")
    private String apiUrl;

    private Random random = SecureRandom.getInstanceStrong();

    public void consultaCep(String cep){
        apiUrl += cep;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForEntity(apiUrl, CepDTO.class);
    }

    public String getToken() {
        StringBuilder token = new StringBuilder();
        for(int i = 0; i < 255; i++) {
            char c = (char) (this.random.nextInt(26) + 'a');
            
            token.append(c);
        }
        return token.toString();
    }
    
}