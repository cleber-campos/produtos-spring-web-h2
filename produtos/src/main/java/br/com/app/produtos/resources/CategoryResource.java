package br.com.app.produtos.resources;

import br.com.app.produtos.entities.Category;
import br.com.app.produtos.repositories.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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


}
