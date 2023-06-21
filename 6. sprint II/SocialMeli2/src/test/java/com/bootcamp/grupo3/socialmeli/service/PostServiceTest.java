package com.bootcamp.grupo3.socialmeli.service;

import com.bootcamp.grupo3.socialmeli.dto.request.PostDTO;
import com.bootcamp.grupo3.socialmeli.dto.request.ProductDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserPostListDTO;
import com.bootcamp.grupo3.socialmeli.model.Post;
import com.bootcamp.grupo3.socialmeli.model.Product;
import com.bootcamp.grupo3.socialmeli.repository.PostRepository;
import com.bootcamp.grupo3.socialmeli.repository.interfaces.IPostRepository;
import com.bootcamp.grupo3.socialmeli.service.interfaces.IUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
class PostServiceTest {

    @Spy
    ModelMapper modelMapper;
    @Mock
    IUserService userService;
    @Mock
    IPostRepository postRepository;

    @InjectMocks
    PostService postService;

    List<Integer> followed;
    List<PostDTO> sortedList;
    Product producto1;
    Product producto2;
    Product producto3;
    Product producto4;
    Product producto5;
    Product producto6;
    List<Post> postList1;
    List<Post> postList2;
    @BeforeEach
    void setUp() {
        followed = List.of(1,2);

        producto1 = new Product(1, "PocoPhone", "Celular", "Xiaomi", "Negro", "alto Celu");
        producto3 = new Product(3, "Redmi 13", "Celular", "Xiaomi", "Negro", "alto Celu");

        producto4 = new Product(4, "A51", "Celular", "Samsung", "Negro", "alto Celu");
        producto5 = new Product(5, "A39", "Celular", "Samsung", "Negro", "alto Celu");
        producto6 = new Product(6, "A60", "Celular", "Samsung", "Negro", "alto Celu");

        LocalDate time = LocalDate.now();
        postList1 = List.of(
                new Post(1, 1, time.minusDays(1), producto1, 100, 2500D),
                //new Post(2, 1, time.minusDays(3), producto2, 102, 5550D),
                new Post(3, 1, time, producto3, 101, 7770D)
        );
        postList2 = List.of(
                new Post(4, 2, time.minusDays(5), producto4, 100, 33500D),
                new Post(5, 2, time.minusDays(10), producto5, 101, 9950D),
                new Post(6, 2, time.minusDays(7), producto6, 102, 6670D)
        );

        sortedList = Stream.of(
                new PostDTO(1, time.minusDays(1), new ProductDTO(), 100, 2500D),
                //new PostDTO(1, time.minusDays(3), new ProductDTO(), 102, 5500D),
                new PostDTO(1, time, new ProductDTO(), 101, 7770D),
                new PostDTO(2, time.minusDays(5), new ProductDTO(), 100, 33500D),
                new PostDTO(2, time.minusDays(10), new ProductDTO(), 101, 9950D),
                new PostDTO(2, time.minusDays(7), new ProductDTO(), 102, 6670D)
        ).toList();

    }

    @Test
    void createPost() {
    }

    @Test
    void getPostList() {
        List<PostDTO> expected = this.sortedList.stream().sorted(Comparator.comparing(PostDTO::getDate)).toList();
        when(userService.getFollowedByUser(0)).thenReturn(followed);
        when(postRepository.getPostsByUserInTwoWeeks(1)).thenReturn(postList1);
        when(postRepository.getPostsByUserInTwoWeeks(2)).thenReturn(postList2);

        UserPostListDTO postList = postService.getPostList(0, "date_asc");

        Assertions.assertEquals(expected.size(), postList.getPosts().size());
        Assertions.assertArrayEquals(expected.toArray(), postList.getPosts().toArray());
    }

    @Test
    void getPostListReversedOrder() {

        List<PostDTO> expected = this.sortedList.stream().sorted(Comparator.comparing(PostDTO::getDate).reversed()).toList();

        when(userService.getFollowedByUser(0)).thenReturn(followed);
        when(postRepository.getPostsByUserInTwoWeeks(1)).thenReturn(postList1);
        when(postRepository.getPostsByUserInTwoWeeks(2)).thenReturn(postList2);

        UserPostListDTO postList = postService.getPostList(0, "date_desc");

        Assertions.assertEquals(expected.size(), postList.getPosts().size());
        Assertions.assertArrayEquals(expected.toArray(), postList.getPosts().toArray());
    }

    @Test
    void getPostListOrderPrice() {

        List<PostDTO> expected = this.sortedList.stream().sorted(Comparator.comparing(PostDTO::getPrice)).toList();

        when(userService.getFollowedByUser(0)).thenReturn(followed);
        when(postRepository.getPostsByUserInTwoWeeks(1)).thenReturn(postList1);
        when(postRepository.getPostsByUserInTwoWeeks(2)).thenReturn(postList2);

        UserPostListDTO postList = postService.getPostList(0, "price_asc");

        Assertions.assertEquals(expected.size(), postList.getPosts().size());
        Assertions.assertArrayEquals(expected.toArray(), postList.getPosts().toArray());
    }

    @Test
    void getPostListOrderPriceReversed() {

        List<PostDTO> expected = this.sortedList.stream().sorted(Comparator.comparing(PostDTO::getPrice).reversed()).toList();

        when(userService.getFollowedByUser(0)).thenReturn(followed);
        when(postRepository.getPostsByUserInTwoWeeks(1)).thenReturn(postList1);
        when(postRepository.getPostsByUserInTwoWeeks(2)).thenReturn(postList2);

        UserPostListDTO postList = postService.getPostList(0, "price_desc");

        Assertions.assertEquals(expected.size(), postList.getPosts().size());
        Assertions.assertArrayEquals(expected.toArray(), postList.getPosts().toArray());
    }

    @Test
    void getPostOfWeekOfInvalidUser() {
        List<Post> result = postRepository.getPostsByUserInTwoWeeks(10);
        Assertions.assertEquals(0, result.size());
    }
}
