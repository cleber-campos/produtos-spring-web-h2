package br.com.app.produtos;

import br.com.app.produtos.principal.Principal;
import br.com.app.produtos.repositories.ICategoryRepository;
import br.com.app.produtos.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProdutosApplication implements CommandLineRunner {
	@Autowired
	private ICategoryRepository categoryRepository;

	@Autowired
	private IProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProdutosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(categoryRepository, productRepository) ;
		principal.execute();
	}

}
