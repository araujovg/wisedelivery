package br.com.gva.wisedelivery.domain.dtos.restaurante;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import br.com.gva.wisedelivery.domain.CategoriaRestaurante;
import lombok.Data;

@Data
public class RestauranteSalvoDTO {
    
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String confirmaSenha;
    private String telefone;
    private String cnpj;    
	private String cep;
    private String logotipo;
    private BigDecimal taxaEntrega;
    private Integer tempoEntrega;
    private String token;
    private Set<CategoriaRestaurante> categorias = new HashSet<>();
}