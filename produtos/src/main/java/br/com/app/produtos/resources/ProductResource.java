package br.com.app.produtos.resources;

import br.com.app.produtos.entities.Product;
import br.com.app.produtos.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
    @Autowired
    public ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        var list = productRepository.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        var prod = productRepository.findById(id);
        return ResponseEntity.ok().body(prod);
    }
}
