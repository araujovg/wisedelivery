package br.com.gva.wisedelivery.domain.dtos;

import lombok.Data;

@Data
public class ClienteInserirDTO {
    
    private Integer id;	
	private String nome;	
	private String email;	
	private String senha;
	private String telefone;
    private String cpf;
}