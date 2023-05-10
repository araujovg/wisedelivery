package br.com.gva.wisedelivery.services.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ImageService {

    @Value("${wisedelivery.arquivos.logotipo}")
    private String diretorioDeUpload;

    public String uploadImage(MultipartFile bytesDaImagem) throws IOException {
        StringBuilder buildNomeArquivo = new StringBuilder();
        Path nomeArquivoECaminho = Paths.get(diretorioDeUpload, bytesDaImagem.getOriginalFilename());
        gravaArquivo(nomeArquivoECaminho, bytesDaImagem.getBytes());
        buildNomeArquivo.append(nomeArquivoECaminho);
        return buildNomeArquivo.toString();
    }
    
    private void gravaArquivo(Path nomeArquivoECaminho, byte[] bytesDaImagem){
        try {
            Files.write(nomeArquivoECaminho, bytesDaImagem, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            try {
                Files.write(nomeArquivoECaminho, bytesDaImagem);
            } catch (IOException e1) {
                log.error("Erro ao salvar a imagem: " + e1.getMessage());
            }
        }
    }
}