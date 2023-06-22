package com.example.be_java_hisp_w21_g1.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/1/follow/2"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.message").value("Accion realizada con exito."))
                .andExpect(jsonPath("$.status").value(200));
    }

    @Test
    @DisplayName("Verificar que solo se pueda seguir a un usuario vendedor")
    void followNonSeller() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/1/follow/3"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El usuario no es un vendedor..."));
    }

    @Test
    @DisplayName("Verificar que tira error al pasar un usuario que no existe")
    void followNonExistentUser() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/1/follow/100"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(jsonPath("$.message").value("Usuarios no encontrados..."));
    }

    @Test
    @DisplayName("Verificar que tire error al pasar un id invalido")
    void followInvalidId() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/0/follow/3"))
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
        int id = 1;
        String expected = "{\"user_id\":1,\"user_name\":Pepe,\"followers_count\":2}";

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/" + id + "/followers/count"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().json(expected));
    }

    @Test
    @DisplayName("Verificar que tire error al pasar un id invalido")
    void followersCountInvalidId() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/0/followers/count"))
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

}