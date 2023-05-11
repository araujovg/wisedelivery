package br.com.gva.wisedelivery;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.gva.wisedelivery.domain.CategoriaItem;
import br.com.gva.wisedelivery.domain.CategoriaRestaurante;
import br.com.gva.wisedelivery.domain.Restaurante;
import br.com.gva.wisedelivery.domain.Restaurante;
import br.com.gva.wisedelivery.repository.CategoriaItemRepository;
import br.com.gva.wisedelivery.repository.CategoriaRestauranteRepository;
import br.com.gva.wisedelivery.repository.RestauranteRepository;

@SpringBootApplication
public class WiseDeliveryApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRestauranteRepository categoriaRestauranteRepository;

	@Autowired
	private CategoriaItemRepository categoriaItemRepository;

	@Autowired
	private RestauranteRepository restauranteRepository;

	public static void main(String[] args) {
		SpringApplication.run(WiseDeliveryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var cat1 = CategoriaRestaurante.builder()
			.nome("Churrasco")
			.imagem("null")
			.build();

		var cat2 = CategoriaRestaurante.builder()
			.nome("Massas")
			.imagem("null")
			.build();

		var cat3 = CategoriaRestaurante.builder()
			.nome("Asiática")
			.imagem("null")
			.build();
		
		var cat4 = CategoriaRestaurante.builder()
			.nome("Frutos do mar")
			.imagem("null")
			.build();

		categoriaRestauranteRepository.saveAll(List.of(cat1, cat2, cat3, cat4));

		var catItem1 = CategoriaItem.builder()
			.nome("Bebida")
			.imagem("catBebida.png")
			.build();

		var catItem2 = CategoriaItem.builder()
			.nome("Lanche")
			.imagem("catLanche.png")
			.build();
			
		var catItem3 = CategoriaItem.builder()
			.nome("Refeição")
			.imagem("catRefeicao.png")
			.build();

		categoriaItemRepository.saveAll(List.of(catItem1, catItem2, catItem3));

		Restaurante rest = new Restaurante();
		rest.setNome("teste");
		rest.setEmail("teste@teste.com");
		rest.setCnpj("11111111111");
		rest.setSenha("1234");
		rest.setTelefone("21999999999");
		rest.setCategorias(Set.of(cat1, cat2));

		restauranteRepository.save(rest);
	}
}
