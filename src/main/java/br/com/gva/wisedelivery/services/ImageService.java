package br.com.gva.wisedelivery.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.gva.wisedelivery.utils.IOUtils;

@Service
public class ImageService {

    @Value("${wisedelivery.arquivos.logotipo}")
    private String pastaLogotipo;

    public void uploadLogotipo(MultipartFile multipartFile, String nomeArquivo) {
        try {
            IOUtils.copiar(multipartFile.getInputStream(), nomeArquivo, pastaLogotipo);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}