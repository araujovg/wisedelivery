package br.com.gva.wisedelivery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.gva.wisedelivery.domain.CategoriaRestaurante;
import br.com.gva.wisedelivery.repository.CategoriaRestauranteRepository;
import br.com.gva.wisedelivery.utils.ServiceUtils;

@SpringBootApplication
public class WiseDeliveryApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRestauranteRepository categoriaRestauranteRepository;

	@Autowired
	private ServiceUtils serviceUtils;

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

		serviceUtils.consultaCep("28908090");
	}
}
