package br.com.app.produtos.repositories;

import br.com.app.produtos.entities.Category;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//exemplo que classe para guardar objeto em memoria
@Component
public class CategoryRepository {
    private Map<Long, Category> map = new HashMap<>();

    public void save(Category obj){
        map.put(obj.getId(), obj);
    }

    public Category findById(Long id){
        return map.get(id);
    }

    public List<Category> findAll(){
        return new ArrayList<Category>(map.values());
    }
}