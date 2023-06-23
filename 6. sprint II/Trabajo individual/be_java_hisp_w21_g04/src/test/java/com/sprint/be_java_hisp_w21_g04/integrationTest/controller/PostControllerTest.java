package com.sprint.be_java_hisp_w21_g04.integrationTest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.sprint.be_java_hisp_w21_g04.dto.request.PostRequestDto;
import com.sprint.be_java_hisp_w21_g04.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.time.LocalDate;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer;

    @BeforeEach
    void setUp() {
        writer=new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .setDateFormat(new StdDateFormat().withColonInTimeZone(true))
                .registerModule(new JSR310Module())
                .writer();
    }

    @Test
    @DisplayName("Test de caso exitoso al agregar un post")
    public void testPostOk() throws Exception {

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(getPostResponseDTO()))
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.message").value("Post agregado exitosamente"))
                .andExpect(result -> result.getResponse().getContentType().equals("application/json"))
                .andReturn();

    }

    @Test
    @DisplayName("Test que espera una excepción al agregar un post con un dato inválido, en este caso el color")
    public void testPostOkThrowExceptionByInvalidColor() throws Exception {

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(getPostResponseDTOError()))
                )
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.messages").value("El color del producto no puede poseer caracteres especiales."))
                .andExpect(result -> result.getResponse().getContentType().equals("application/json"))
                .andReturn();

    }

    @Test
    @DisplayName("Test de caso exitoso al obtener todos los posts de los seguidos por un usuario")
    public void testSellerFollowedListPostsOk() throws Exception{
        mockMvc.perform(get("/products/followed/{userId}/list", 5)
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("order", "date_asc")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andExpect(result -> result.getResponse().getContentType().equals("application/json"))
                .andReturn();
    }

    /**
     * Este método crea un post para ser usado en los tests
     * @return Retorna un objeto PostRequestDto con los datos del post
     */
    private PostRequestDto getPostResponseDTO() {
        return new PostRequestDto(
                1,
                LocalDate.of(2023, 06, 16),
                new Product(2,"Silla Gamer","Gamer","Racer","Red and Black","Special Edition"),
                100,
                1400.00
        );
    }

    /**
     * Este método crea un post con un caracter especial en el color para ser usado en los tests
     * @return Retorna un objeto PostRequestDto con los datos del post
     */
    private PostRequestDto getPostResponseDTOError() {
        return new PostRequestDto(
                1,
                LocalDate.of(2023, 06, 16),
                new Product(2,"Silla Gamer","Gamer","Racer","Red & Black","Special Edition"),
                100,
                1400.00
        );
    }

}
