package com.mercadolibre.blog.controller;

import com.mercadolibre.blog.dto.requestDTO.RequestBlogDTO;
import com.mercadolibre.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*Crear una nueva entrada de Blog y devolver un mensaje adecuado diciendo que ha sido creada correctamente
mostrando su “Id”. (URI: /blog).

En el caso de que ya exista una entrada de blog con ese “Id”, capturar la excepción y devolver un mensaje
indicando dicha situación.

Devolver la información de una entrada de Blog específico, recibiendo el “Id” del mismo. (URI: /blog/{id}).
Si el “Id” ingresado no corresponde a ninguna entrada de Blog, indicarlo con un mensaje adecuado.
Devolver el listado de todas las entradas de blogs existentes. (URI: /blogs).
*/
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    IBlogService blogService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getBlogById(@PathVariable int id){
        return blogService.getBlogById(id);
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> getBlogs(){
        return blogService.getAllBlogs();
    }

    @PostMapping
    public ResponseEntity<?> insertBlog(@RequestBody RequestBlogDTO requestBlogDTO){
        return  blogService.insertBlog(requestBlogDTO);
    }

}
