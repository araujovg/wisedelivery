package br.com.gva.wisedelivery.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Entity
@Table(name = "restaurante")
public class Restaurante extends Usuario {

    private String cnpj;

	private String cep;

    private String logotipo;


    private BigDecimal taxaEntrega;

    private Integer tempoEntrega;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "restaurante_has_categoria",
        joinColumns = @JoinColumn(name = "restaurante_id"),
        inverseJoinColumns = @JoinColumn(name = "categoria_restaurante_id")
    )
    @Size(min = 1, message = "O Restaurante precisa ter pelo menos uma categoria")
    @ToString.Exclude
    private Set<CategoriaRestaurante> categorias = new HashSet<>(0);
    
}
