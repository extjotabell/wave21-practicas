package com.example.Blog.repository;

import com.example.Blog.entity.EntradaBlog;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Repository
public class RepositorioBlog {
    List<EntradaBlog> entradas = new ArrayList<>();

    public void addBlog (EntradaBlog entrada)
    {
        entradas.add(entrada);
    }
}
