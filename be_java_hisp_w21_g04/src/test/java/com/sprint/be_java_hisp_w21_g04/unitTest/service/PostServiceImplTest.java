package com.sprint.be_java_hisp_w21_g04.unitTest.service;

import com.sprint.be_java_hisp_w21_g04.dto.response.PostResponseDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.SellerFollowedListPostResponseDto;
import com.sprint.be_java_hisp_w21_g04.entity.Post;
import com.sprint.be_java_hisp_w21_g04.entity.Product;
import com.sprint.be_java_hisp_w21_g04.entity.User;
import com.sprint.be_java_hisp_w21_g04.exception.EmptySellerFollowedList;
import com.sprint.be_java_hisp_w21_g04.exception.IllegalDataException;
import com.sprint.be_java_hisp_w21_g04.exception.UserNotFoundException;
import com.sprint.be_java_hisp_w21_g04.repository.post.PostRepositoryImpl;
import com.sprint.be_java_hisp_w21_g04.repository.user.IUserRepository;
import com.sprint.be_java_hisp_w21_g04.service.post.PostServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
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
    @DisplayName("T-0006 : Verificar el correcto ordenamiento ascendente por fecha. (US-0009)")
    public void testSortedPostsDateAsc(){
        //Arrange
        int userId = 1;
        String order = "date_asc";

        List<Post> mockResult = new ArrayList<>();
        Product product1 = new Product(1, "Camiseta", "T Shirt", "Nike", "Red", "");
        mockResult.add(new Post(userId, LocalDate.now().minusDays(10), product1, 10, 100, true, 10));
        Product product2 = new Product(1, "Short", "Short", "Adidas", "Brown", "");
        mockResult.add(new Post(userId, LocalDate.now().minusDays(5), product2, 6, 160, true, 10));
        Product product3 = new Product(1, "Camiseta", "T Shirt", "Adidas", "White", "");
        mockResult.add(new Post(1, LocalDate.now(), product3, 4, 120, true, 10));

        List<PostResponseDto> expectedPosts = new ArrayList<>();
        Product product4 = new Product(1, "Camiseta", "T Shirt", "Nike", "Red", "");
        expectedPosts.add(new PostResponseDto(userId, LocalDate.now().minusDays(10), product4, 10, 100));
        Product product5 = new Product(1, "Short", "Short", "Adidas", "Brown", "");
        expectedPosts.add(new PostResponseDto(userId, LocalDate.now().minusDays(5), product5, 6, 160));
        Product product6 = new Product(1, "Camiseta", "T Shirt", "Adidas", "White", "");
        expectedPosts.add(new PostResponseDto(1, LocalDate.now(), product6, 4, 120));
        SellerFollowedListPostResponseDto expectedResult = new SellerFollowedListPostResponseDto(userId, expectedPosts);

        List<Integer> followers = Arrays.asList(1, 2, 3, 5);
        List<Integer> followed = Arrays.asList(1, 2, 3, 5);
        User user = new User(1, "Pedro", followers, followed);

        when(userRepository.getById(userId)).thenReturn(user);
        when(postRepository.getSellerFollowed(userId)).thenReturn(mockResult);


        //Act
        SellerFollowedListPostResponseDto result = postService.sellerFollowedListPosts(userId, order);

        //Assert
        assertEquals(3, result.getPosts().size());
        assertTrue(result.getPosts().get(0).getDate().isBefore(result.getPosts().get(1).getDate()));
        assertEquals(expectedResult, result);
    }
    @Test
    @DisplayName("T-0006 : Verificar el correcto ordenamiento descendente por fecha. (US-0009)")
    public void testSortedPostsDateDes(){
        //Arrange
        int userId = 1;
        String order = "date_desc";

        List<Post> mockResult = new ArrayList<>();
        Product product1 = new Product(1, "Camiseta", "T Shirt", "Nike", "Red", "");
        mockResult.add(new Post(userId, LocalDate.now(), product1, 10, 100, true, 10));
        Product product2 = new Product(1, "Short", "Short", "Adidas", "Brown", "");
        mockResult.add(new Post(userId, LocalDate.now().minusDays(5), product2, 6, 160, true, 10));
        Product product3 = new Product(1, "Camiseta", "T Shirt", "Adidas", "White", "");
        mockResult.add(new Post(1, LocalDate.now().minusDays(10), product3, 4, 120, true, 10));

        List<PostResponseDto> expectedPosts = new ArrayList<>();
        Product product4 = new Product(1, "Camiseta", "T Shirt", "Nike", "Red", "");
        expectedPosts.add(new PostResponseDto(userId, LocalDate.now(), product4, 10, 100));
        Product product5 = new Product(1, "Short", "Short", "Adidas", "Brown", "");
        expectedPosts.add(new PostResponseDto(userId, LocalDate.now().minusDays(5), product5, 6, 160));
        Product product6 = new Product(1, "Camiseta", "T Shirt", "Adidas", "White", "");
        expectedPosts.add(new PostResponseDto(1, LocalDate.now().minusDays(10), product6, 4, 120));
        SellerFollowedListPostResponseDto expectedResult = new SellerFollowedListPostResponseDto(userId, expectedPosts);

        List<Integer> followers = Arrays.asList(1, 2, 3, 5);
        List<Integer> followed = Arrays.asList(1, 2, 3, 5);
        User user = new User(1, "Pedro", followers, followed);

        when(userRepository.getById(userId)).thenReturn(user);
        when(postRepository.getSellerFollowed(userId)).thenReturn(mockResult);


        //Act
        SellerFollowedListPostResponseDto result = postService.sellerFollowedListPosts(userId, order);

        //Assert
        assertEquals(3, result.getPosts().size());
        assertTrue(result.getPosts().get(0).getDate().isAfter(result.getPosts().get(1).getDate()));
        assertEquals(expectedResult, result);
    }
    @Test
    @DisplayName("Extra: Verificar que si retorne todas los post")
    public void testPostsGetAll(){
        //Arrange
        List<Post> mockResult = new ArrayList<>();
        Product product1 = new Product(1, "Camiseta", "T Shirt", "Nike", "Red", "");
        mockResult.add(new Post(1, LocalDate.now(), product1, 10, 100, true, 10));
        Product product2 = new Product(1, "Short", "Short", "Adidas", "Brown", "");
        mockResult.add(new Post(2, LocalDate.now().minusWeeks(3), product2, 6, 160, true, 10));
        Product product3 = new Product(1, "Camiseta", "T Shirt", "Adidas", "White", "");
        mockResult.add(new Post(3, LocalDate.now().minusDays(20), product3, 4, 120, true, 10));

        List<PostResponseDto> expectedPosts = new ArrayList<>();
        Product product4 = new Product(1, "Camiseta", "T Shirt", "Nike", "Red", "");
        expectedPosts.add(new PostResponseDto(1, LocalDate.now(), product4, 10, 100));
        Product product5 = new Product(1, "Short", "Short", "Adidas", "Brown", "");
        expectedPosts.add(new PostResponseDto(2, LocalDate.now().minusWeeks(3), product5, 6, 160));
        Product product6 = new Product(1, "Camiseta", "T Shirt", "Adidas", "White", "");
        expectedPosts.add(new PostResponseDto(3, LocalDate.now().minusDays(20), product6, 4, 120));


        when(postRepository.getAll()).thenReturn(mockResult);


        //Act
        List<PostResponseDto> result = postService.getAll();

        //Assert
        assertEquals(3, result.size());
        assertEquals(expectedPosts, result);
    }

    @Test
    @DisplayName("Verificar que el usuario exista")
    public void testUserNotFoundException(){
        //arrange
        when(userRepository.getById(anyInt())).thenReturn(null);

        //Act and assert
        assertThrows(UserNotFoundException.class, ()-> postService.sellerFollowedListPosts(1, "date_asc"));
    }

    @Test
    @DisplayName("Verificar que los vendedores que sigue tengan publicaciones")
    public void testEmptySellerFollowedList(){
        //Arrange
        int userId = 1;
        String order = "date_desc";

        List<Integer> followers = Arrays.asList(1, 2, 3, 5);
        List<Integer> followed = Arrays.asList(1, 2, 3, 5);
        User user = new User(1, "Pedro", followers, followed);

        when(userRepository.getById(userId)).thenReturn(user);
        when(postRepository.getSellerFollowed(userId)).thenReturn(Collections.emptyList());

        //Act and Assert
        assertThrows(EmptySellerFollowedList.class, () -> postService.sellerFollowedListPosts(userId, order));
    }

    @Test
    @DisplayName("T-0008 : Verificar que la consulta de publicaciones " +
            "realizadas en las últimas dos semanas de un determinado " +
            "vendedor sean efectivamente de las últimas dos semanas. (US-0006)")
    public void testEmptySellerFollowedListWhenNoRecentPosts(){
        //Arrange
        int userId = 1;
        String order = "date_desc";
        User user = mock(User.class);
        Post oldPost = mock(Post.class);

        when(oldPost.getDate()).thenReturn(LocalDate.now().minusWeeks(3));
        when(userRepository.getById(anyInt())).thenReturn(user);
        when(postRepository.getSellerFollowed(anyInt())).thenReturn(List.of(oldPost));

        //Act and Assert
        assertThrows(EmptySellerFollowedList.class, () -> postService.sellerFollowedListPosts(userId, order));
    }

    @Test
    @DisplayName("T-0005: Verificar que el tipo de ordenamiento por fecha exista (US-0009)")
    public void testIllegalDataException(){
        //Arrange
        int userId = 1;
        String order = "XXXXXXX";

        //Act and Assert
        assertThrows(IllegalDataException.class, ()-> postService.sellerFollowedListPosts(userId, order));
    }
    @Test
    @DisplayName("Verificar que no se lance ninguna excepción")
    public void testNoExceptions(){
        //Arrange
        int userId = 1;
        String order = "date_desc";
        User user = mock(User.class);
        Post oldPost = mock(Post.class);

        when(oldPost.getDate()).thenReturn(LocalDate.now());
        when(userRepository.getById(anyInt())).thenReturn(user);
        when(postRepository.getSellerFollowed(anyInt())).thenReturn(List.of(oldPost));

        //Act and Assert
        assertDoesNotThrow(()-> postService.sellerFollowedListPosts(userId, order));
    }

}
