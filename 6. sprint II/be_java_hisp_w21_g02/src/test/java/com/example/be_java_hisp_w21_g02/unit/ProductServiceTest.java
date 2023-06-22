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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ProductServiceTest {

    @Mock
    UserRepositoryImpl userRepository;

    @InjectMocks
    ProductsServiceImpl productsService;

    private static User user;
    private static Product product;
    private static ProductDTO productDTO;
    private static List<User> userList = new ArrayList<>();
    private static List<PostDTO> postsDTO = new ArrayList<>();

    @BeforeEach
    void setUp(){
        user = new User(1, "Usuario1", Set.of(2, 3),
                Collections.emptySet(), Collections.emptyList()
        );
        product = new Product();
        productDTO = new ProductDTO();
        userList = List.of(
                new User(2, "Usuario2", Collections.emptySet(), Collections.emptySet(),
                        List.of(new Post(2, 1, LocalDate.now().minusDays(1), 3, 50D, product),
                                new Post(2, 2, LocalDate.now().minusDays(2), 3, 50D, product))),
                new User(3, "Usuario3", Collections.emptySet(), Collections.emptySet(),
                        List.of(new Post(3, 3, LocalDate.now().minusDays(3), 3, 50D, product),
                                new Post(3, 4, LocalDate.now().minusDays(4), 3, 50D, product))));

        postsDTO = List.of(
                new PostDTO(2, 1, LocalDate.now().minusDays(1), productDTO, 3, 50D),
                new PostDTO(2, 2, LocalDate.now().minusDays(2), productDTO, 3, 50D),
                new PostDTO(3, 3, LocalDate.now().minusDays(3), productDTO, 3, 50D),
                new PostDTO(3, 4, LocalDate.now().minusDays(4), productDTO, 3, 50D));
    }

    @Test
    @DisplayName("Unit Test US09 T-0005 T01 - OrderNotExists")
    void listFollowingPosts2WeeksTestOrderNotExists() {
        // Arrange
        String order = "order_not_exists";

        // Act & Assert
        assertThrows(OrderNotFoundException.class, () ->
                productsService.listFollowingPosts2Weeks(1, order)
        );
    }

    @Test
    @DisplayName("Unit Test US09 T-0005 T02 - EmptyOrder")
    void listFollowingPosts2WeeksTestEmptyOrder() {
        // Arrange
        String order = "";

        // Act & Assert
        assertThrows(OrderNotFoundException.class, () ->
                productsService.listFollowingPosts2Weeks(1, order)
        );
    }

    @Test
    @DisplayName("Unit Test US09 T-0005-03 - NullOrder")
    void listFollowingPosts2WeeksTestNullOrder() {
        // Arrange
        String order = null;
        List<PostDTO> postsDTODesc =  postsDTO.stream().sorted(Comparator.comparing(PostDTO::getDate).reversed()).toList();
        ResponseEntity<UserPostResponseDTO> expected = ResponseEntity.ok(new UserPostResponseDTO(1, postsDTODesc));

        Mockito.when(userRepository.getUser(1)).thenReturn(user);
        Mockito.when(userRepository.listFollowingPosts2Weeks(1)).thenReturn(userList);

        // Act
        ResponseEntity<?> result = productsService.listFollowingPosts2Weeks(1, order);

        // Assert
        Assertions.assertEquals(expected.getBody(), result.getBody());
    }

    @Test
    @DisplayName("Unit Test US09 T-0006-01 - Correct Order Desc (Date)")
    void listFollowingPosts2WeeksTestCorrectOrderDesc(){
        // Arrange
        List<PostDTO> postsDTODesc =  postsDTO.stream().sorted(Comparator.comparing(PostDTO::getDate).reversed()).toList();
        ResponseEntity<UserPostResponseDTO> expected = ResponseEntity.ok(new UserPostResponseDTO(1, postsDTODesc));

        Mockito.when(userRepository.getUser(1)).thenReturn(user);
        Mockito.when(userRepository.listFollowingPosts2Weeks(1)).thenReturn(userList);

        // Act
        ResponseEntity<?> result = productsService.listFollowingPosts2Weeks(1, "date_desc");

        // Assert
        Assertions.assertEquals(expected.getBody(), result.getBody());
    }

    @Test
    @DisplayName("Unit Test US09 T-0006-02 - Correct Order Asc (Date)")
    void listFollowingPosts2WeeksTestCorrectOrderAsc(){
        // Arrange
        List<PostDTO> postsDTOAsc =  postsDTO.stream().sorted(Comparator.comparing(PostDTO::getDate)).toList();
        ResponseEntity<UserPostResponseDTO> expected = ResponseEntity.ok(new UserPostResponseDTO(1, postsDTOAsc));

        Mockito.when(userRepository.getUser(1)).thenReturn(user);
        Mockito.when(userRepository.listFollowingPosts2Weeks(1)).thenReturn(userList);

        // Act
        ResponseEntity<?> result = productsService.listFollowingPosts2Weeks(1, "date_asc");

        // Assert
        Assertions.assertEquals(expected.getBody(), result.getBody());
    }

    @Test
    @DisplayName("Unit Test US06 T-0008-01 - Obtain a list of posts from users that the user follows in the last 2 weeks in descendent date order")
    void listFollowingPosts2WeeksTestObtainedListIsOk() {
        // Arrange
        ResponseEntity<UserPostResponseDTO> expected = ResponseEntity.ok(new UserPostResponseDTO(1, postsDTO));

        Mockito.when(userRepository.getUser(1)).thenReturn(user);
        Mockito.when(userRepository.listFollowingPosts2Weeks(1)).thenReturn(userList);

        // Act
        ResponseEntity<?> result = productsService.listFollowingPosts2Weeks(1, "date_desc");

        // Assert
        Assertions.assertEquals(expected.getBody(), result.getBody());
    }

    @Test
    @DisplayName("Unit Test US06 T-0008-02 - UserNotExists")
    void listFollowingPosts2WeeksTestUserNotExists() {
        // Arrange
        int userId = 2000000;
        String order = "date_desc";

        // Act & Assert
        assertThrows(UserNotFoundException.class, () ->
                productsService.listFollowingPosts2Weeks(userId, order)
        );
    }

    @Test
    @DisplayName("Unit Test US06 T-0008-03 - Post Not Exist")
    void listFollowingPosts2WeeksTestPostNotExists() {
        // Arrange
        ResponseEntity<UserPostResponseDTO> expected = new ResponseEntity<>(new UserPostResponseDTO(user.getId(), Collections.emptyList()), HttpStatus.OK);
        
        Mockito.when(userRepository.listFollowingPosts2Weeks(user.getId())).thenReturn(Collections.emptyList());
        Mockito.when(userRepository.getUser(1)).thenReturn(user);

        // Act
        ResponseEntity<?> response = productsService.listFollowingPosts2Weeks(user.getId(), null);

        // Assert
        Assertions.assertEquals(expected, response);
    }
}