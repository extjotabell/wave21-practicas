package com.example.be_java_hisp_w21_g1.integration;
import com.example.be_java_hisp_w21_g1.DTO.Request.PostProductDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.ProductDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.time.LocalDate;
@SpringBootTest
@AutoConfigureMockMvc
public class Controller {
    @Autowired
    MockMvc mockMvc;
    ObjectWriter writer = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .writer();

    @Test
    @DisplayName("PostControllerIntegration - post character integration")
    void postAProduct() throws Exception {
        PostProductDTO postProductDTO = new PostProductDTO(1, LocalDate.now(), new ProductDTO(1, "Desk", "test", "test", "test", "test"), 1, 1.0);
        //request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post").contentType(MediaType.APPLICATION_JSON).content(writer.writeValueAsString(postProductDTO));
        String expected = "Se ha creado el post!";
        //expected
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentExpected = MockMvcResultMatchers.content().string("Se ha creado el post!");
        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentExpected)
                .andDo(MockMvcResultHandlers.print());
    }

}





