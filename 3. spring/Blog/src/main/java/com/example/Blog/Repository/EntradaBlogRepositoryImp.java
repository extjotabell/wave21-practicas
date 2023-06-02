package com.example.Blog.Repository;

import com.example.Blog.Entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class EntradaBlogRepositoryImp implements EntradaBlogRepository {

    Map<Integer, EntradaBlog> blogsMap =  new HashMap<>();
    @Override
    public boolean saveBlog(EntradaBlog model) {
        if(blogsMap.containsKey(model.getId())){
            return false;
        }
        else {
            this.blogsMap.put(model.getId(), model);
            return true;
        }
    }
}
