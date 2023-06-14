package com.mercadolibre.romannumerals;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class RomanNumeralsRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("REtorno I cuando ingreso 1")
    void returnOneRomanTest() throws  Exception{
     mockMvc.perform(MockMvcRequestBuilders.get("/{number}",1 ))
             .andDo(MockMvcResultHandlers.print())
             .andExpect(status().isOk())
             .andExpect(mvcResult -> mvcResult.getResponse().equals("I"));

    }
    @Test
    @DisplayName("REtorno III cuando ingreso 3")
    void returnThreeRomanTest() throws  Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/{number}",3 ))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(mvcResult -> mvcResult.getResponse().equals("III"));

    }

    @Test
    @DisplayName("REtorno V cuando ingreso 5")
    void returnFiveRomanTest() throws  Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/{number}",5 ))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(mvcResult -> mvcResult.getResponse().equals("V"));

    }

    @Test
    @DisplayName("REtorno VII cuando ingreso 7")
    void returnSevenRomanTest() throws  Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/{number}",7 ))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(mvcResult -> mvcResult.getResponse().equals("VII"));

    }

    @Test
    @DisplayName("REtorno X cuando ingreso 10")
    void returnTenRomanTest() throws  Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/{number}",10 ))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(mvcResult -> mvcResult.getResponse().equals("X"));

    }

    @Test
    @DisplayName("REtorno L cuando ingreso 50")
    void returnfiftyRomanTest() throws  Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/{number}",50 ))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(mvcResult -> mvcResult.getResponse().equals("L"));

    }
}
