package br.com.gva.wisedelivery.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class IOUtils {

    public static void copiar(InputStream entrada, String nomeArquivo, String dirSaida)throws IOException {
        Files.copy(entrada, Paths.get(dirSaida, nomeArquivo), StandardCopyOption.REPLACE_EXISTING);
    }
    
}
