package wave21.Blog.service;

import org.springframework.stereotype.Service;
import wave21.Blog.dto.request.BlogDTO;
import wave21.Blog.exceptions.NotExistsException;
import wave21.Blog.model.Blog;
import wave21.Blog.repository.BlogRepository;

import java.util.List;

@Service
public class BlogService {
    BlogRepository repository;

    public BlogService(BlogRepository repository){
        this.repository = repository;
    }

    public void addBlog(BlogDTO entryDTO){
        BlogDTO blogDTO = entryDTO;
        Blog blog = new Blog();

        blog.setId(repository.getEntradas().size());
        blog.setTitulo(blogDTO.getTitulo());
        blog.setAutorName(blogDTO.getAutorName());
        blog.setFechaPublicacion(blogDTO.getFechaPublicacion());
    }

    //if ya existe la entry
        //throw new AlreadyExistsException("El libro de id: " + id + "ya existe!");

    public BlogDTO findBlog(String id){
        BlogDTO entryDTO = new BlogDTO();
        Blog entry = repository.findEntryById(id);
        if(entry == null) {
            throw new NotExistsException("El libro de id: " + id + " no existe!");
        }
        entryDTO.setAutorName(entry.getAutorName());
        entryDTO.setTitulo(entry.getTitulo());
        entryDTO.setFechaPublicacion(entry.getFechaPublicacion());

        return entryDTO;
    }

    public List<BlogDTO> getAllBlogs(){
        List<Blog> entradas = repository.getEntradas();
        List<BlogDTO> entradasDTO = entradas.stream()
                .map(entry -> {
                    BlogDTO entryDTO = new BlogDTO();
                    entryDTO.setTitulo(entry.getTitulo());
                    entryDTO.setAutorName(entry.getAutorName());
                    entryDTO.setFechaPublicacion(entry.getFechaPublicacion());
                    return entryDTO;
                })
                .toList();
        return entradasDTO;
    }

}
