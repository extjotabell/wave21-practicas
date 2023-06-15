package com.example.excepciones_P1_VIVO.repository;

import com.example.excepciones_P1_VIVO.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EntradaBlogRepository implements IEntradaBlogRepository{
    List<EntradaBlog> entradaBlogList = new ArrayList<>();


    @Override
    public void save(EntradaBlog entradaBlog) {
        entradaBlogList.add(entradaBlog);
    }

    @Override
    public List<EntradaBlog> getAll() {
        return entradaBlogList;
    }

    @Override
    public EntradaBlog getById(Integer id) {
        EntradaBlog blogId = entradaBlogList.stream()
                .filter(n -> n.getId().equals(id))
                .findFirst()
                .orElse(null);

        return blogId;
    }
}
