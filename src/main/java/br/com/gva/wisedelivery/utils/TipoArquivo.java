package br.com.gva.wisedelivery.utils;

import lombok.Getter;

public enum TipoArquivo {

    PNG("image/png", "png"),
    JPG("image/jpeg", "jpg");

    @Getter String mimeType;
    @Getter String extension;

    TipoArquivo(String mimeType, String extension) {
        this.mimeType = mimeType;
        this.extension = extension;
    }

    public boolean mesmoQue(String mimeType) {
        return this.mimeType.equalsIgnoreCase(mimeType);
    }

    public static TipoArquivo of(String mimeType) {
        for(TipoArquivo tipo : values()) {
            if(tipo.mesmoQue(mimeType)){
                return tipo;
            }
        }
        return null;
    }
    
}