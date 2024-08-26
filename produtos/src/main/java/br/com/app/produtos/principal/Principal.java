package br.com.app.produtos.principal;

import br.com.app.produtos.entities.Category;
import br.com.app.produtos.entities.Product;
import br.com.app.produtos.repositories.ICategoryRepository;
import br.com.app.produtos.repositories.IProductRepository;
import br.com.app.produtos.repositories.ProductRepository;
import java.util.Arrays;

public class Principal {
    private final ICategoryRepository categoryRepository;
    private final IProductRepository productRepository;

    public Principal(ICategoryRepository categoryRepository, IProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    public void execute() {
        teste();

    }


    public void teste(){
        //criacao de categorias
        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");

        categoryRepository.save(cat1);
        categoryRepository.save(cat2);

        //criacao de produtos
        Product prod1 = new Product(null,"TV", 2200.00, cat1);
        Product prod2 = new Product(null,"Domain Driven Design", 120.00, cat2);
        Product prod3 = new Product(null,"PS5", 2800.00, cat1);
        Product prod4 = new Product(null,"Docker", 120.00, cat2);
        productRepository.save(prod1);
        productRepository.save(prod2);
        productRepository.save(prod3);
        productRepository.save(prod4);

        //Incluindo os produtos na categoria
        cat1.getProducts().addAll(Arrays.asList(prod1,prod3));
        cat2.getProducts().addAll(Arrays.asList(prod2,prod4));


    }

}
