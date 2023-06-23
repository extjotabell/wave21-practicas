package com.bootcamp.grupo3.socialmeli.integrationtest;
import com.bootcamp.grupo3.socialmeli.dto.request.PostDTO;
import com.bootcamp.grupo3.socialmeli.dto.request.ProductDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserPostListDTO;
import com.bootcamp.grupo3.socialmeli.model.Post;
import com.bootcamp.grupo3.socialmeli.model.Product;
import com.bootcamp.grupo3.socialmeli.model.User;
import com.bootcamp.grupo3.socialmeli.repository.PostRepository;
import com.bootcamp.grupo3.socialmeli.repository.UserRepository;
import com.bootcamp.grupo3.socialmeli.repository.interfaces.IPostRepository;
import com.bootcamp.grupo3.socialmeli.repository.interfaces.IUserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.bootcamp.grupo3.socialmeli.dto.response.MessageDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    IUserRepository userRepository;
    @Autowired
    IPostRepository postRepository;
    ObjectWriter writer = new ObjectMapper().registerModule(new JavaTimeModule()).writer();

    @DisplayName("Test Integracion para Crear un post -")
    @Test
    @Rollback
    void createPostTest() throws Exception {
        //-------ARRANGE -----------

        LocalDate time = LocalDate.now().minusDays(3);
        ProductDTO product1 = new ProductDTO(1, "Silla Gamer", "Gamer", "Racer", "Red", "specialEdition");

        PostDTO req = new PostDTO(1,time, product1, 100, 50400D  );
        String reqParsed = writer.writeValueAsString(req);

        //La request

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/products/post")
                .content(reqParsed)
                .contentType(MediaType.APPLICATION_JSON)
                ;
        //los expected

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpeted = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request) //ejecutar la request
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Post agregado exitosamente"))) //cotejar body
                .andExpect(statusExpected) //cotejar status
                .andExpect(contentTypeExpeted) //cotejar contentType
                .andDo(MockMvcResultHandlers.print())
        ;
    }


    @DisplayName("Test Integracion. Obtener Listado de publicaciones de seguidos de id dado, en las ultimas 2 semanas")
    @Test
    @Rollback
    void listPostOfFollowedTest() throws Exception {

        //ARRANGE
        /*
        Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).
         */

        //crear 3 usuarios llamando el constructor de UserRepository - LISTO

        //crear 3 productosDTO
        ProductDTO pDTO1 = new ProductDTO(1, "Mochila", "Carga", "Zara", "Negra", "Excelente producto");
        ProductDTO pDTO2 = new ProductDTO(2, "Notebook", "Computadora", "Mac", "Plateada", "Para oficina" );
        ProductDTO pDTO3 = new ProductDTO(3, "Silla", "Asiento", "Blocky", "Negra", "Muy comoda");
        //crear 1 post para el user 1 y 2 post para el user 2
        PostDTO postDTO1 = new PostDTO( 1, LocalDate.now().minusDays(2), pDTO1, 100, 40500D );
        PostDTO postDTO2 = new PostDTO( 2, LocalDate.now().minusDays(3), pDTO2, 200, 850400D );
        PostDTO postDTO3 = new PostDTO( 2, LocalDate.now().minusWeeks(3), pDTO3, 450, 299300D );

        //lo mismo que lo anterior pero como entidad
        Product p1 = new Product(1, "Mochila", "Carga", "Zara", "Negra", "Excelente producto");
        Product p2 = new Product(2, "Notebook", "Computadora", "Mac", "Plateada", "Para oficina" );
        Product p3 = new Product(3, "Silla", "Asiento", "Blocky", "Negra", "Muy comoda");
        Post post1 = new Post( 1,1, LocalDate.now().minusDays(2), p1, 100, 40500D );
        Post post2 = new Post( 2,2, LocalDate.now().minusDays(3), p2, 200, 850400D );
        Post post3 = new Post( 3,2, LocalDate.now().minusWeeks(3), p3, 450, 299300D );


        //Traigo los usuarios para generar los seguimientos
        User user1 = userRepository.getUserByID(1).get();
        User user2 = userRepository.getUserByID(2).get();
        User user3 = userRepository.getUserByID(3).get();

        //asgino quien sigue a quien
        userRepository.getUserByID(3).get().getFollowed().add(user1);
        userRepository.getUserByID(3).get().getFollowed().add(user2);
        userRepository.getUserByID(1).get().getFollowers().add(user3);
        userRepository.getUserByID(2).get().getFollowers().add(user3);

        //agrego los post en el repositorio
        postRepository.createPost(post1);
        postRepository.createPost(post2);
        postRepository.createPost(post3);


        //request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/products/followed/{userId}/list", 3)
                .contentType(MediaType.APPLICATION_JSON);
        //expected
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //creo la lista de postDTO que voy a esperar
        List<PostDTO> postListBody = List.of(postDTO1,postDTO2);
        UserPostListDTO list = new UserPostListDTO(3, postListBody);
        String reqJson = writer.writeValueAsString(list);
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(reqJson);


        //ASSERT
        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(bodyExpected)// agregue 3 post, pero solo 2 tienen q retornarse
                .andDo(MockMvcResultHandlers.print());


    }




}
