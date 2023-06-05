package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.request.BlogDTORequest;
import com.bootcamp.blog.dto.response.MessageDTO;
import com.bootcamp.blog.dto.response.BlogDTOResponse;
import com.bootcamp.blog.exception.NotFoundException;
import com.bootcamp.blog.model.BlogEntry;
import com.bootcamp.blog.repository.BlogRepo;
import com.bootcamp.blog.utils.Mapper;
import com.bootcamp.blog.exception.RepetedBlogEntryException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BlogService {

    BlogRepo blogRepo;


    public BlogService(BlogRepo blogRepo) {
        this.blogRepo = blogRepo;
    }

    public MessageDTO addNewEntry(BlogDTORequest blog){

        Integer newEntryId = blogRepo.addBlog(Mapper.mapFromDTORequest(blog));
        if (Objects.isNull(newEntryId)){
            throw new RepetedBlogEntryException("Ya existe una entrada de blog con id: " + blog.getId());
        }
        return new MessageDTO("Entrada de blog creada correctamente con id: " + newEntryId, 201);
    }

    public BlogDTOResponse getEntryByID(int id){
       BlogEntry foundBlog = blogRepo.getEntryByID(id);
       if (Objects.isNull(foundBlog)){
           throw new NotFoundException("No se encontró la entrada de blog " + id);
       }
     return Mapper.mapFromBlogToResponse(foundBlog);
    }

    public List<BlogDTOResponse> getAllEntries(){
        return blogRepo.getAllEntries().stream().map(Mapper::mapFromBlogToResponse).toList();
    }
}