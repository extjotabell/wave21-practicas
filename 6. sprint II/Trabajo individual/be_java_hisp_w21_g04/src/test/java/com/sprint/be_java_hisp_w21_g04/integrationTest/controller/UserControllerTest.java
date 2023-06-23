package com.sprint.be_java_hisp_w21_g04.integrationTest.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectWriter;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import org.junit.jupiter.api.BeforeEach;


@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

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
    public void testGetFollowedByIdWithFollowedThrowsException() throws Exception {
        mockMvc.perform(get("/users/{userId}/followed/list",1)
                        .param("order", "name_asc")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.message").value("El usuario no sigue a ningún vendedor"))
                .andExpect(result -> result.getResponse().getContentType().equals("application/json"))
                .andReturn();
    }

    @Test
    public void testGetFollowersByIdWithFollowersThrowsException() throws Exception {
        mockMvc.perform(get("/users/{userId}/followers/list",1)
                        .param("order", "name_asc")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.message").value("No se encontraron seguidores para el vendedor"))
                .andExpect(result -> result.getResponse().getContentType().equals("application/json"))
                .andReturn();
    }

    @Test
    public void testGetFollowedByIdWithInvalidSortThrowsException() throws Exception {
        mockMvc.perform(get("/users/{userId}/followed/list",1)
                        .param("order", "name_")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.message").value("Ordenamiento invalido"))
                .andExpect(result -> result.getResponse().getContentType().equals("application/json"))
                .andReturn();
    }

    @Test
    public void testGetFollowersByIdWithInvalidSortThrowsException() throws Exception {
        mockMvc.perform(get("/users/{userId}/followers/list",1)
                        .param("order", "name_")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.message").value("Ordenamiento invalido"))
                .andExpect(result -> result.getResponse().getContentType().equals("application/json"))
                .andReturn();
    }


    @Test
    public void testUserUnfollowThrowsException() throws Exception {
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}",1,2)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.message").value("No se están siguiendo."))
                .andExpect(result -> result.getResponse().getContentType().equals("application/json"))
                .andReturn();
    }

}
