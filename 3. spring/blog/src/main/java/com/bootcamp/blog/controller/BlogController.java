package com.bootcamp.blog.controller;

import com.bootcamp.blog.dto.response.MessageDTO;
import com.bootcamp.blog.dto.request.BlogDTORequest;
import com.bootcamp.blog.dto.response.BlogDTOResponse;
import com.bootcamp.blog.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/blog")
    public ResponseEntity<MessageDTO> createNewBlog(@RequestBody BlogDTORequest blog) {
        return new ResponseEntity<>(blogService.addNewEntry(blog), HttpStatus.CREATED);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDTOResponse> getEntryByID(@PathVariable int id) {
        return ResponseEntity.ok(blogService.getEntryByID(id));
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDTOResponse>> getAllEntries() {
        return ResponseEntity.ok(blogService.getAllEntries());
    }

}
