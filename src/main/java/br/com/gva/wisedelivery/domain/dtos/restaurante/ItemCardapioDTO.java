package br.com.gva.wisedelivery.domain.dtos.restaurante;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ItemCardapioDTO {

    private Long id;
    private String nome;
    private String descricao;
    private List<String> categorias;
    private String imagem;
    private MultipartFile arquivoImagemDoItem;
    private BigDecimal preco;
    private boolean destaque;
    private Long restauranteId;
}
