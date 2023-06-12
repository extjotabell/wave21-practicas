package wave21.Blog.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wave21.Blog.dto.request.BlogDTO;
import wave21.Blog.service.BlogService;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class BlogController {
    BlogService service;

    public BlogController(BlogService service){
        this.service = service;
    }

    @PostMapping("addBlog")
    public ResponseEntity<BlogDTO> addBlog(@RequestBody BlogDTO entryDto){
        return new ResponseEntity<>(service.addBlog(entryDto), OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDTO> findBlog(@PathVariable String id){
        return new ResponseEntity<>(service.findBlog(id), OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDTO>> getAllBlogs(){
        return new ResponseEntity<>(service.getAllBlogs(), OK);
    }


    /*n
La API debe ser capaz de:

Crear una nueva entrada de Blog y devolver un mensaje adecuado diciendo que ha sido creada correctamente mostrando su “Id”. (URI: /blog).
En el caso de que ya exista una entrada de blog con ese “Id”, capturar la excepción y devolver un mensaje indicando dicha situación.

Devolver la información de una entrada de Blog específico, recibiendo el “Id” del mismo. (URI: /blog/{id}).
Si el “Id” ingresado no corresponde a ninguna entrada de Blog, indicarlo con un mensaje adecuado.

Devolver el listado de todas las entradas de blogs existentes. (URI: /blogs).

Implementar las clases de excepciones personalizadas que hagan falta.
Manejar el tratamiento de las excepciones utilizando alguno de los métodos vistos.
*/
}
