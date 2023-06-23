package com.example.be_java_hisp_w21_g1.integration;

import com.example.be_java_hisp_w21_g1.DTO.Request.PostProductDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.FollowUserDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.FollowedListDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.ProductDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();
    }

    // FOLLOW USER

    @Test
    @DisplayName("Verificar que se pueda seguir a un usuario")
    void followTestHappy() throws Exception {
        int userId = 1;
        int userIdToFollow = 2;

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.message").value("Accion realizada con exito."))
                .andExpect(jsonPath("$.status").value(200));
    }

    @Test
    @DisplayName("Verificar que solo se pueda seguir a un usuario vendedor")
    void followNonSeller() throws Exception {
        int userId = 1;
        int userIdToFollow = 3;

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userID}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El usuario no es un vendedor..."));
    }

    @Test
    @DisplayName("Verificar que tira error al pasar un usuario que no existe")
    void followNonExistentUser() throws Exception {
        int userId = 100;
        int userIdToFollow = 3;

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userID}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(jsonPath("$.message").value("Usuarios no encontrados..."));
    }

    @Test
    @DisplayName("Verificar que tire error al pasar un id invalido")
    void followInvalidId() throws Exception {
        int userId = 0;
        int userIdToFollow = 3;

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(jsonPath("$.message").value("The following errors were found: "))
                .andExpect(jsonPath("$.allErrors[0]").value("User_id can't be less than 0"));
    }

    // FOLLOWERS COUNT
    @Test
    @DisplayName("Verificar que se pueda obtener la cantidad de seguidores de un usuario")
    void followersCountTestHappy() throws Exception {
        int userId = 1;
        String expected = "{\"user_id\":1,\"user_name\":Pepe,\"followers_count\":2}";

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userID}/followers/count", userId))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().json(expected));
    }

    @Test
    @DisplayName("Verificar que tire error al pasar un id invalido")
    void followersCountInvalidId() throws Exception {
        int userId = 0;

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", userId))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(jsonPath("$.message").value("The following errors were found: "))
                .andExpect(jsonPath("$.allErrors[0]").value("User_id can't be less than 0"));
    }

    @Test
    @DisplayName("Verificar que tire error al pasar un id que no existe")
    void followersCountNonExistentUser() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/100/followers/count"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(jsonPath("$.message").value("No se encontro el usuario con el ID100"));
    }

    // CREATE POST
    @Test
    @DisplayName("Verificar que se pueda crear un post")
    void createPostTestHappy() throws Exception {
        String expected = "{\"message\":\"Accion realizada con exito.\",\"status\":200}";
        ProductDTO product = new ProductDTO(1, "Computadora Gamer", "Electronica", "Asus", "Negro", null);
        PostProductDTO post = new PostProductDTO(1, LocalDate.now(), product, 100, 1500.00);


        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType("application/json")
                        .content(writer.writeValueAsString(post)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$").value("Se ha creado el post!"));
    }

    @Test
    @DisplayName("Verificar que solo acepta daros validos")
    void createPostTestUnhappy() throws Exception {
        String[] expectedStrings = {"Price cannot be higher than 10.000.000",
                "Color can't contain special characters", "Category can't be empty",
                "The date cannot be null", "Product_id can't be less than 0",
                "Brand name can't contain special characters",
                "Type can't contain special characters or be empty",
                "Notes can't contain special characters", "User_id can't be less than 0",
                "Product name can't contain special characters or be empty"};

        ProductDTO product = new ProductDTO(-1, "Computadora & Gamer", "Electronica &", "Asus $", "Negro $", "notas $");
        PostProductDTO post = new PostProductDTO(-1, null, product, null, 100000000.00);


        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType("application/json")
                        .content(writer.writeValueAsString(post)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(jsonPath("$.message").value("The following errors were found: "))
                .andExpect(jsonPath("$.allErrors").isArray())
                .andReturn();

        String response = result.getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(response);
        JsonNode allErrorsNode = jsonNode.get("allErrors");
        List<String> errorList = objectMapper.readValue(allErrorsNode.toString(), new TypeReference<List<String>>() {});

        Assertions.assertTrue(errorList.containsAll(Arrays.asList(expectedStrings)));

    }

    // FOLLOWED LIST

    @Test
    @DisplayName("Verificar la lista de followers")
    void followedListTestHappy() throws Exception {
        int userId = 1;
        FollowedListDTO expectedFolloweds = new FollowedListDTO(1, "Pepe", Arrays.asList(new FollowUserDTO(2, "Pablo"), new FollowUserDTO(3, "Pedro")));


        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userID}/followers/list", userId))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.user_id").value(expectedFolloweds.getUser_id()))
                .andExpect(jsonPath("$.user_name").value(expectedFolloweds.getUser_name()))
                .andExpect(jsonPath("$.followers").isArray())
                .andExpect(jsonPath("$.followers[0].user_id").value(expectedFolloweds.getFollowed().get(0).getUser_id()))
                .andExpect(jsonPath("$.followers[0].user_name").value(expectedFolloweds.getFollowed().get(0).getUser_name()))
                .andExpect(jsonPath("$.followers[1].user_id").value(expectedFolloweds.getFollowed().get(1).getUser_id()))
                .andExpect(jsonPath("$.followers[1].user_name").value(expectedFolloweds.getFollowed().get(1).getUser_name()));
        ;
    }

    @Test
    @DisplayName("Verificar la lista de followers con ordenamiento descendente")
    void followedListTestHappyDesc() throws Exception {
        int userId = 1;
        FollowedListDTO expectedFolloweds = new FollowedListDTO(1, "Pepe", Arrays.asList(new FollowUserDTO(3, "Pedro"), new FollowUserDTO(2, "Pablo")));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userID}/followers/list?order=name_desc", userId))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.user_id").value(expectedFolloweds.getUser_id()))
                .andExpect(jsonPath("$.user_name").value(expectedFolloweds.getUser_name()))
                .andExpect(jsonPath("$.followers").isArray())
                .andExpect(jsonPath("$.followers[0].user_id").value(expectedFolloweds.getFollowed().get(0).getUser_id()))
                .andExpect(jsonPath("$.followers[0].user_name").value(expectedFolloweds.getFollowed().get(0).getUser_name()))
                .andExpect(jsonPath("$.followers[1].user_id").value(expectedFolloweds.getFollowed().get(1).getUser_id()))
                .andExpect(jsonPath("$.followers[1].user_name").value(expectedFolloweds.getFollowed().get(1).getUser_name()));
    }

    // DEJAR DE SEGUIR A UN USUARIO

    @Test
    @DisplayName("Verificar que se deja de seguir a un usuario")
    void unfollowUserTestHappy() throws Exception {
        int userId = 1;
        int followedId = 2;

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userID}/unfollow/{followedID}", userId, followedId))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Verificar que devuelve un error al intentar dejar de seguir a un usuario que no se sigue")
    void unfollowUserTestUnhappy() throws Exception {
        int userId = 1;
        int followedId = 3;

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userID}/unfollow/{followedID}", userId, followedId))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}