package com.bootcamp.grupo3.socialmeli.repository;

import com.bootcamp.grupo3.socialmeli.model.Post;
import com.bootcamp.grupo3.socialmeli.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PostRepositoryTest {
    @InjectMocks
    PostRepository postRepository;

    @Test
    @DisplayName("T-0008 / Verificar que la consulta de publicaciones realizadas en las últimas dos semanas de un determinado vendedor sean efectivamente de las últimas dos semanas. (US-0006) / Permite continuar con normalidad.")
    void getPostOfWeek() {
        LocalDate today = LocalDate.now();
        List<Post> expected = List.of(
                new Post(5, 2, today, new Product(), 100, 500d),
                new Post(6, 2, today.minusDays(3), new Product(), 100, 500d)
        );

        List<Post> posts = List.of(
                new Post(1, 1, today.minusYears(1), new Product(), 100, 500d),
                new Post(2, 1, today.minusDays(20), new Product(), 100, 500d),
                new Post(3, 1, today.minusMonths(2), new Product(), 100, 500d),
                new Post(4, 1, today.minusMonths(3), new Product(), 100, 500d),
                new Post(5, 2, today, new Product(), 100, 500d),
                new Post(6, 2, today.minusDays(3), new Product(), 100, 500d)
        );

        posts.forEach(p -> postRepository.createPost(p));
        List<Post> result = postRepository.getPostsByUserInTwoWeeks(2);

        Assertions.assertArrayEquals(expected.toArray(), result.toArray());
    }
}


