package br.com.gva.wisedelivery.domain.dtos.restaurante;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import br.com.gva.wisedelivery.domain.CategoriaRestaurante;
import br.com.gva.wisedelivery.utils.TipoArquivo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RestauranteDTO {
    
    private Long id;

    @NotBlank(message = "Nome não pode estar vazio")
    @Size(max = 80)
    private String nome;

    @NotBlank(message = "Email não pode estar vazio")
    @Size(max = 60)
    @Email(message = "Formato de e-mail inválido")
    private String email;

    @NotBlank(message = "Senha não pode estar vazia")
    @Size(max = 80)
    private String senha;

    @NotBlank(message = "Confirmação de senha não pode estar vazia")
    @Size(max = 80)
    private String confirmaSenha;

    @NotBlank(message = "Telefone não pode estar vazio")
    @Size(max = 20)
    private String telefone;

    @NotBlank(message = "CPF não pode estar vazio")
    @Size(max = 11)
    @Pattern(regexp = "[0-9]{11}")
    private String cnpj;
    
	private String cep;
    private MultipartFile arquivoLogotipo;
    private String logotipo;
    private BigDecimal taxaEntrega;
    private Integer tempoEntrega;
    private Set<CategoriaRestaurante> categorias = new HashSet<>();

    public void setLogotipoFileName() {

        if(id == null) {
            throw new IllegalStateException("É preciso salvar o arquivo");
        }

        //this.logotipo = String.format("%04d-logo.%s", getId(), TipoArquivo.of(logotipoFile.getContentType()).getExtension());

    }
}