package br.com.app.produtos.principal;

import br.com.app.produtos.entities.Category;
import br.com.app.produtos.entities.Product;
import br.com.app.produtos.repositories.CategoryRepository;
import br.com.app.produtos.repositories.ProductRepository;
import java.util.Arrays;

public class Principal {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public Principal(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    public void execute() {
        teste();

    }


    public void teste(){
        //criacao de categorias
        Category cat1 = new Category(1L, "Electronics");
        Category cat2 = new Category(2L, "Books");

        //criacao de produtos
        Product prod1 = new Product(1L, "TV", 2200.00, cat1);
        Product prod2 = new Product(2L, "Domain Driven Design", 120.00, cat2);
        Product prod3 = new Product(3L, "PS5", 2800.00, cat1);
        Product prod4 = new Product(2L, "Docker", 120.00, cat2);

        //vinculando a categoria ao produto
        cat1.getProducts().addAll(Arrays.asList(prod1, prod3));
        cat2.getProducts().addAll(Arrays.asList(prod2, prod4));

        categoryRepository.save(cat1);
        categoryRepository.save(cat2);

        productRepository.save(prod1);
        productRepository.save(prod2);
        productRepository.save(prod3);
        productRepository.save(prod4);

    }

}
