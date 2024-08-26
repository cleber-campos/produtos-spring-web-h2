package br.com.app.produtos.resources;

import br.com.app.produtos.entities.Category;
import br.com.app.produtos.repositories.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private ICategoryRepository categoryRepository;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        var list = categoryRepository.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Category>> findById(@PathVariable Long id){
        var cat = categoryRepository.findById(id);
        return ResponseEntity.ok().body(cat);
    }

    //Metodo para salvar um nova categoria
    @PostMapping(value = "/{id}")
    public ResponseEntity<Category> save(@RequestBody Category category){
        var cat = categoryRepository.save(category);
        categoryRepository.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(cat);
    }

    //Metodo para alterar uma categoria
    @PutMapping(value = "/{id}")
    public ResponseEntity<Category> update(@PathVariable Long id, @RequestBody Category updateCategory) {
        categoryRepository.findById(id).map(category -> {
                    category.setNome(updateCategory.getNome());
                    Category savedCategory = categoryRepository.save(category);
                    return ResponseEntity.ok().body(savedCategory);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateCategory);
    }
}

