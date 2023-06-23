package com.example.livecodingtest.controller;

import com.example.livecodingtest.dto.ResponseDto;
import com.example.livecodingtest.dto.TestPostDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class  PracticaTestIntegracion {

    @Autowired
    MockMvc mockMvc;

    /*
     * Testear un Método GET y verificar contenido de la respuesta
     *
     * Response
     * {
     *   "id":1,
     *   "message":"Hello World"
     * }
     *
     * */

    @Test
    public void testHelloWorldOk() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/sayHello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Hello World"))
                .andReturn();

        assertEquals("application/json",mvcResult.getResponse().getContentType());
    }

    /*
     *URL request: http://localhost:8080/sayHello/Martin
     *
     *Testear un metodo GET con un pathVariable
     * {
     *   "id":1,
     *   "message":"Hello Martin"
     * }
     *
     */

    @Test
    public void testSayHelloPathVariableOk() throws Exception{
        mockMvc.perform(get("/sayHello/{name}", "Martin"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Hello Martin"));
    }

    /*
     *URL request: http://localhost:8080/sayHello?name=Martin
     *
     *Testear un metodo GET con un RequestParam
     * {
     *   "id":1,
     *   "message":"Hello Martin"
     * }
     *
     */

    @Test
    public void testSayHelloRequestParamOk()throws Exception{
        mockMvc.perform(get("/sayHello2")
                    .param("name","Martin"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Hello Martin"));

    }

    /*
     *URL request: http://localhost:8080/postHello
     *
     *Testear un metodo POST y verificar que el contenido de la respuesta sea el esperado
     * {
     *   "id":1,
     *   "message":"Hello Martin"
     * }
     *
     */

    @Test
    public void testSayHelloPost() throws Exception {

        TestPostDto testPostDto= new TestPostDto("Martin");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String jsonPayload = writer.writeValueAsString(testPostDto);

        mockMvc.perform(post("/postHello")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Hello Martin"))
                .andExpect(jsonPath("$.id").value(1));
    }

    /*
     *URL request: http://localhost:8080/postHello
     *
     *Testear un metodo POST y verificar que el contenido de la respuesta sea el esperado en su totalidad
     * {
     *   "id":1,
     *   "message":"Hello Martin"
     * }
     *
     */

    @Test
    public void testSayHelloPostResponseComplete() throws Exception {

        TestPostDto testPostDto= new TestPostDto("Martin");
        ResponseDto responseDto = new ResponseDto(1,"Hello Martin");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String jsonPayload = writer.writeValueAsString(testPostDto);
        String responseJson = writer.writeValueAsString(responseDto);

        MvcResult mvcResult = mockMvc.perform(post("/postHello")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(responseJson,mvcResult.getResponse().getContentAsString());
    }
}
