package br.com.gva.wisedelivery.domain.dtos.restaurante;

import br.com.gva.wisedelivery.domain.Restaurante;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Data
public class ItemCardapioDTO {

    private Long id;
    private String nome;
    private String descricao;
    private String categoria;
    private String imagem;
    private MultipartFile arquivoUploadImagem;
    private BigDecimal preco;
    private boolean destaque;
    private Restaurante restaurante;
}
