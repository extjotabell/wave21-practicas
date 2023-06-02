package com.example.blog.services;

import com.example.blog.dto.request.BlogRequestDto;
import com.example.blog.dto.response.BlogResponseDto;
import com.example.blog.entities.Blog;
import com.example.blog.exception.DuplicateKeyException;
import com.example.blog.exception.NotFoundException;
import com.example.blog.exception.IllegalDataException;
import com.example.blog.repositories.IBlogRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BlogService implements IBlogService {

    private IBlogRepository _repository;
    private ModelMapper _mapper;

    public BlogService(IBlogRepository repository){
        this._repository = repository;
        _mapper = new ModelMapper();
    }

    @Override
    public UUID createBlog(BlogRequestDto blogDto) {
        try
        {
            Blog blog = new Blog(UUID.fromString(blogDto.getId()),blogDto.getTitle(),blogDto.getName(),blogDto.getPublicationDate());
            if(_repository.getAll().stream().anyMatch(blog1 -> blog1.getId().equals(blog.getId()))){
                throw new DuplicateKeyException("Blog ya existe, no se puede crear");
            }
            else{
                return _repository.createBlog(blog);
            }
        }
        catch(IllegalArgumentException e){
            throw new IllegalDataException("Id no válido");
        }

    }

    @Override
    public BlogResponseDto getById(UUID id) {
        Blog blog = _repository.getById(id);
        return _mapper.map(blog,BlogResponseDto.class);
    }

    @Override
    public List<BlogResponseDto> getAll() {
        List<BlogResponseDto> list = _repository.getAll().stream().map(blog -> _mapper.map(blog,BlogResponseDto.class)).toList();
        if(!list.isEmpty())return list;
        else throw new NotFoundException("No hay entradas de blog");
    }
}
