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
    @DisplayName("Unit Test US08 T01 - Obtain a list of posts from users that the user follows in the last 2 weeks in descendent date order")
    void listFollowingPosts2WeeksTestObtainedListIsOk() {
        // Arrange
        User user = new User(1, "Usuario1", Set.of(2, 3),
                Collections.emptySet(), Collections.emptyList()
        );
        Product product = new Product();
        ProductDTO productDTO = new ProductDTO();
        List<User> list = List.of(
                new User(2, "Usuario2", Collections.emptySet(), Collections.emptySet(),
                        List.of(new Post(2, 1, LocalDate.now().minusDays(1), 3, 50D, product),
                                new Post(2, 2, LocalDate.now().minusDays(2), 3, 50D, product))),
                new User(3, "Usuario3", Collections.emptySet(), Collections.emptySet(),
                        List.of(new Post(3, 3, LocalDate.now().minusDays(3), 3, 50D, product),
                                new Post(3, 4, LocalDate.now().minusDays(4), 3, 50D, product))));

        List<PostDTO> postsDTO = List.of(
                new PostDTO(2, 1, LocalDate.now().minusDays(1), productDTO, 3, 50D),
                new PostDTO(2, 2, LocalDate.now().minusDays(2), productDTO, 3, 50D),
                new PostDTO(3, 3, LocalDate.now().minusDays(3), productDTO, 3, 50D),
                new PostDTO(3, 4, LocalDate.now().minusDays(4), productDTO, 3, 50D));

        ResponseEntity<UserPostResponseDTO> expected = ResponseEntity.ok(new UserPostResponseDTO(1, postsDTO));

        // Mock
        Mockito.when(userRepository.getUser(1)).thenReturn(user);
        Mockito.when(userRepository.listFollowingPosts2Weeks(1)).thenReturn(list);

        // Act
        ResponseEntity<?> result = productsService.listFollowingPosts2Weeks(1, "date_desc");

        // Assert
        Assertions.assertEquals(expected.getBody(), result.getBody());
    }

    @Test
    @DisplayName("Unit Test US08 T02 - OrderNotExists")
    void listFollowingPosts2WeeksTestOrderNotExists() {
        // Arrange
        String order = "order_not_exists";

        // Act & Assert
        assertThrows(OrderNotFoundException.class, () ->
            productsService.listFollowingPosts2Weeks(1, order)
        );
    }

    @Test
    @DisplayName("Unit Test US08 T03 - UserNotExists")
    void listFollowingPosts2WeeksTestUserNotExists() {
        // Arrange
        int userId = 2000000;
        String order = "date_desc";

        // Act & Assert
        assertThrows(UserNotFoundException.class, () ->
            productsService.listFollowingPosts2Weeks(userId, order)
        );
    }
}