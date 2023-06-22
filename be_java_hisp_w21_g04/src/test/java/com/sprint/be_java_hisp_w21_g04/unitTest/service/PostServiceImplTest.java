package com.sprint.be_java_hisp_w21_g04.unitTest.service;

import com.sprint.be_java_hisp_w21_g04.dto.response.PostResponseDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.SellerFollowedListPostResponseDto;
import com.sprint.be_java_hisp_w21_g04.entity.Post;
import com.sprint.be_java_hisp_w21_g04.entity.Product;
import com.sprint.be_java_hisp_w21_g04.entity.User;
import com.sprint.be_java_hisp_w21_g04.repository.post.PostRepositoryImpl;
import com.sprint.be_java_hisp_w21_g04.repository.user.IUserRepository;
import com.sprint.be_java_hisp_w21_g04.service.post.PostServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostServiceImplTest {

    @Mock
    PostRepositoryImpl postRepository;

    @Mock
    IUserRepository userRepository;

    @InjectMocks
    PostServiceImpl postService;

    @Test
    public void testSortedPostsDateAsc(){
        //Arrange
        int userId = 1;
        String order = "date_asc";

        List<Post> mockResult = new ArrayList<>();
        Product product1 = new Product(1, "Camiseta", "T Shirt", "Nike", "Red", "");
        mockResult.add(new Post(userId, LocalDate.of(2023, 6, 15), product1, 10, 100, true, 10));
        Product product2 = new Product(1, "Short", "Short", "Adidas", "Brown", "");
        mockResult.add(new Post(userId, LocalDate.of(2023, 6, 18), product2, 6, 160, true, 10));
        Product product3 = new Product(1, "Camiseta", "T Shirt", "Adidas", "White", "");
        mockResult.add(new Post(1, LocalDate.of(2023, 6, 20), product3, 4, 120, true, 10));

        List<PostResponseDto> expectedPosts = new ArrayList<>();
        Product product4 = new Product(1, "Camiseta", "T Shirt", "Nike", "Red", "");
        expectedPosts.add(new PostResponseDto(userId, LocalDate.of(2023, 6, 15), product4, 10, 100));
        Product product5 = new Product(1, "Short", "Short", "Adidas", "Brown", "");
        expectedPosts.add(new PostResponseDto(userId, LocalDate.of(2023, 6, 18), product5, 6, 160));
        Product product6 = new Product(1, "Camiseta", "T Shirt", "Adidas", "White", "");
        expectedPosts.add(new PostResponseDto(1, LocalDate.of(2023, 6, 20), product6, 4, 120));
        SellerFollowedListPostResponseDto expectedResult = new SellerFollowedListPostResponseDto(userId, expectedPosts);

        List<Integer> followers = Arrays.asList(1, 2, 3, 5);
        List<Integer> followed = Arrays.asList(1, 2, 3, 5);
        User user = new User(1, "Pedro", followers, followed);

        when(userRepository.getById(userId)).thenReturn(user);
        when(postRepository.getSellerFollowed(userId)).thenReturn(mockResult);


        //Act
        SellerFollowedListPostResponseDto result = postService.sellerFollowedListPosts(userId, order);

        //Assert
        assertEquals(expectedResult, result);
    }
    @Test
    public void testSortedPostsDateDes(){
        //Arrange
        int userId = 1;
        String order = "date_desc";

        List<Post> mockResult = new ArrayList<>();
        Product product1 = new Product(1, "Camiseta", "T Shirt", "Nike", "Red", "");
        mockResult.add(new Post(userId, LocalDate.of(2023, 6, 20), product1, 10, 100, true, 10));
        Product product2 = new Product(1, "Short", "Short", "Adidas", "Brown", "");
        mockResult.add(new Post(userId, LocalDate.of(2023, 6, 18), product2, 6, 160, true, 10));
        Product product3 = new Product(1, "Camiseta", "T Shirt", "Adidas", "White", "");
        mockResult.add(new Post(1, LocalDate.of(2023, 6, 15), product3, 4, 120, true, 10));

        List<PostResponseDto> expectedPosts = new ArrayList<>();
        Product product4 = new Product(1, "Camiseta", "T Shirt", "Nike", "Red", "");
        expectedPosts.add(new PostResponseDto(userId, LocalDate.of(2023, 6, 20), product4, 10, 100));
        Product product5 = new Product(1, "Short", "Short", "Adidas", "Brown", "");
        expectedPosts.add(new PostResponseDto(userId, LocalDate.of(2023, 6, 18), product5, 6, 160));
        Product product6 = new Product(1, "Camiseta", "T Shirt", "Adidas", "White", "");
        expectedPosts.add(new PostResponseDto(1, LocalDate.of(2023, 6, 15), product6, 4, 120));
        SellerFollowedListPostResponseDto expectedResult = new SellerFollowedListPostResponseDto(userId, expectedPosts);

        List<Integer> followers = Arrays.asList(1, 2, 3, 5);
        List<Integer> followed = Arrays.asList(1, 2, 3, 5);
        User user = new User(1, "Pedro", followers, followed);

        when(userRepository.getById(userId)).thenReturn(user);
        when(postRepository.getSellerFollowed(userId)).thenReturn(mockResult);


        //Act
        SellerFollowedListPostResponseDto result = postService.sellerFollowedListPosts(userId, order);

        //Assert
        assertEquals(expectedResult, result);
    }

}
