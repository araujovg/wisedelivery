package br.com.gva.wisedelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gva.wisedelivery.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}