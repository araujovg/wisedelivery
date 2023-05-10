package br.com.gva.wisedelivery.services.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ImageService {

    @Getter @Setter
    private static String diretorioDeUpload;

    public String uploadImage(MultipartFile bytesDaImagem) throws IOException {
        StringBuilder buildNomeArquivo = new StringBuilder();
        Path nomeArquivoECaminho = Paths.get(diretorioDeUpload, bytesDaImagem.getOriginalFilename());
        gravaArquivo(nomeArquivoECaminho, bytesDaImagem.getBytes());
        buildNomeArquivo.append(nomeArquivoECaminho);
        return buildNomeArquivo.toString();
    }

    public static String criarPastaDeUpload(){
        Path diretorioCriado = Paths.get("");
        try {
            diretorioCriado = Files.createDirectory(Paths.get(System.getProperty("user.home") + "/Dev/uploads"));
            log.info("Diretório criado com sucesso: " + diretorioCriado);
        } catch (IOException e) {
            log.error("Erro ao criar o diretório: " + e.getMessage());
        }
        setDiretorioDeUpload(diretorioCriado.toString());
        return diretorioDeUpload;
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