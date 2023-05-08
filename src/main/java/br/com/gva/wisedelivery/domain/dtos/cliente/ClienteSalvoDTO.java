package br.com.gva.wisedelivery.domain.dtos.cliente;

import lombok.Data;

@Data
public class ClienteSalvoDTO {
    
    private Integer id;	
	private String nome;	
	private String email;
	private String telefone;
    private String cpf;
}