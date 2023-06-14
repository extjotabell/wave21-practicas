package com.bootcamp.grupo3.socialmeli.service;

import com.bootcamp.grupo3.socialmeli.dto.request.PostDTO;
import com.bootcamp.grupo3.socialmeli.dto.request.ProductDTO;
import com.bootcamp.grupo3.socialmeli.model.Post;
import com.bootcamp.grupo3.socialmeli.repository.interfaces.IPostRepository;
import com.bootcamp.grupo3.socialmeli.repository.interfaces.IUserRepository;
import com.bootcamp.grupo3.socialmeli.service.interfaces.IProductService;
import com.bootcamp.grupo3.socialmeli.service.interfaces.IUserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class PostTest {
  @Mock
  IPostRepository postRepository;

  @Mock
  IUserService userService;

  @Mock
  IProductService productService;

  @InjectMocks
  PostService postService;

  @Test
  void createPostOk() throws Exception {
    ProductDTO p = new ProductDTO(1, 2,"", "", "", "", "");
    PostDTO b = new PostDTO("", LocalDate.now(), p, 100, 55.99);

    Mockito.when(postRepository.createPost(new Post())).thenReturn(1);
    Mockito.when(userService.userExists("")).thenReturn(true);
    Mockito.when(productService.createProduct(new ProductDTO())).thenReturn(1);

    postService.createPost(b);
  }

}
