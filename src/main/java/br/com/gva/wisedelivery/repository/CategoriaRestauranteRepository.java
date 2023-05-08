package br.com.gva.wisedelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gva.wisedelivery.domain.CategoriaRestaurante;

public interface CategoriaRestauranteRepository extends JpaRepository<CategoriaRestaurante, Long>{
    
}