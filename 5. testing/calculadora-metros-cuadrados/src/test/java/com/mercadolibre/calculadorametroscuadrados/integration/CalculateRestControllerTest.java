package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerTest {
    @Autowired
    MockMvc mockMvc;

    @InjectMocks
    CalculateRestController controller;

    @Test
    @DisplayName("Controller - Calculate")
    public void calculate() throws Exception {

        List<RoomDTO> cuartos = new ArrayList<>();
        //Cuarto
        RoomDTO cuarto = new RoomDTO();
        cuarto.setName("Living");
        cuarto.setLength(10);
        cuarto.setWidth(5);
        cuartos.add(cuarto);
        //Casa
        HouseDTO house = new HouseDTO();
        house.setName("La dorada");
        house.setAddress("Calle falsa 123");
        house.setRooms(cuartos);

        //Set response
        HouseResponseDTO responseDto = new HouseResponseDTO();
        responseDto.setBiggest(cuarto);
        responseDto.setPrice(40000);
        responseDto.setName(house.getName());
        responseDto.setAddress(house.getAddress());
        responseDto.setRooms(house.getRooms());
        responseDto.setSquareFeet(50);


        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String jsonPayload = writer.writeValueAsString(house);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(house));

        mockMvc.perform(post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(contentExpected);


    }
}
