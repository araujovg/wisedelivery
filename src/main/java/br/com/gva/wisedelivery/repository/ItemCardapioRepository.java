package br.com.gva.wisedelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gva.wisedelivery.domain.ItemCardapio;

public interface ItemCardapioRepository extends JpaRepository<ItemCardapio, Long> {

    List<ItemCardapio> findAllByRestauranteId(Long restauranteId);
}
