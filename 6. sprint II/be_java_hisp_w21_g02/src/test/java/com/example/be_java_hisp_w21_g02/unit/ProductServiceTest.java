package com.example.be_java_hisp_w21_g02.unit;

import com.example.be_java_hisp_w21_g02.dto.PostDTO;
import com.example.be_java_hisp_w21_g02.dto.ProductDTO;
import com.example.be_java_hisp_w21_g02.dto.response.UserPostResponseDTO;
import com.example.be_java_hisp_w21_g02.exceptions.OrderNotFoundException;
import com.example.be_java_hisp_w21_g02.exceptions.UserNotFoundException;
import com.example.be_java_hisp_w21_g02.model.Post;
import com.example.be_java_hisp_w21_g02.model.Product;
import com.example.be_java_hisp_w21_g02.model.User;
import com.example.be_java_hisp_w21_g02.repository.UserRepositoryImpl;
import com.example.be_java_hisp_w21_g02.service.ProductsServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    UserRepositoryImpl userRepository;

    @InjectMocks
    ProductsServiceImpl productsService;

    @Test
    @DisplayName("Unit Test T08 - OK")
    void listFollowingPosts2WeeksTestOk(){
        // Arrange
        User user = new User(1, "Usuario1", Set.of(2, 3),
                Collections.emptySet(), Collections.emptyList()
        );

        List<User> list = List.of(
                new User(2, "Usuario2", Collections.emptySet(),Collections.emptySet(),
                        List.of(new Post(2, 1, LocalDate.now().minusDays(1), 3, 50D, new Product()),
                                new Post(2, 2, LocalDate.now().minusDays(2), 3, 50D, new Product()))),
                new User(3, "Usuario3", Collections.emptySet(),Collections.emptySet(),
                        List.of(new Post(3, 3, LocalDate.now().minusDays(3), 3, 50D, new Product()),
                                new Post(3, 4, LocalDate.now().minusDays(4), 3, 50D, new Product()))));

        List<PostDTO> postsDTO = List.of(
                new PostDTO(2, 1, LocalDate.now().minusDays(1), new ProductDTO(), 50, 100D),
                new PostDTO(2, 2, LocalDate.now().minusDays(2), new ProductDTO(), 50, 100D),
                new PostDTO(3, 3, LocalDate.now().minusDays(3), new ProductDTO(), 50, 100D),
                new PostDTO(3, 4, LocalDate.now().minusDays(4), new ProductDTO(), 50, 100D));

        ResponseEntity<UserPostResponseDTO> expected = ResponseEntity.ok(new UserPostResponseDTO(1, postsDTO));

        // Mock
        Mockito.when(userRepository.getUser(1)).thenReturn(user);
        Mockito.when(userRepository.listFollowingPosts2Weeks(1)).thenReturn(list);

        // Act
        ResponseEntity<UserPostResponseDTO> result =  (ResponseEntity<UserPostResponseDTO>) productsService.listFollowingPosts2Weeks(1, "date_desc");

        // Assert
        Assertions.assertEquals(expected.getStatusCode(), result.getStatusCode());

        Assertions.assertEquals(expected.getBody().getPosts().get(0).getPostId(),result.getBody().getPosts().get(0).getPostId());
        Assertions.assertEquals(expected.getBody().getPosts().get(1).getPostId(),result.getBody().getPosts().get(1).getPostId());
        Assertions.assertEquals(expected.getBody().getPosts().get(2).getPostId(),result.getBody().getPosts().get(2).getPostId());
        Assertions.assertEquals(expected.getBody().getPosts().get(3).getPostId(),result.getBody().getPosts().get(3).getPostId());
    }

    @Test
    @DisplayName("Unit Test T08 - OrderNotExists")
    void listFollowingPosts2WeeksTestOrderNotExists() {
        // Arrange
        String order = "order_not_exists";

        // Act & Assert
        assertThrows(OrderNotFoundException.class, () ->{
            productsService.listFollowingPosts2Weeks(1, order);
        });
    }

    @Test
    @DisplayName("Unit Test T08 - UserNotExists")
    void listFollowingPosts2WeeksTestUserNotExists() {
        // Arrange
        int userId = 2000000;

        // Mock
        Mockito.when(userRepository.getUser(userId)).thenThrow(UserNotFoundException.class);

        // Act & Assert
        assertThrows(UserNotFoundException.class, () -> {
            userRepository.getUser(userId);
        });
    }
}