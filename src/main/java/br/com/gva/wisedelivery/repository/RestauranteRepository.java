package br.com.gva.wisedelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gva.wisedelivery.domain.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long>{
    Restaurante findByEmail(String email);
}