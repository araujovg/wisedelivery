package br.com.gva.wisedelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gva.wisedelivery.domain.CategoriaItem;

public interface CategoriaItemRepository extends JpaRepository<CategoriaItem, Long>{
    
}