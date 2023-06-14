package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.jayway.jsonpath.JsonPath;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcResultHandlersDsl;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
//@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class CalculateControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void intTest() throws Exception {
        // Arrange
        RoomDTO living = new RoomDTO("Living", 10, 10);
        RoomDTO kitchen = new RoomDTO("Kitchen", 7, 5);
        RoomDTO bathroom = new RoomDTO("Bathroom", 5, 2);

        HouseDTO house = new HouseDTO("House", "Address", List.of(living, kitchen, bathroom) );

        HouseResponseDTO expected = new HouseResponseDTO();
        expected.setName("House");
        expected.setAddress("Address");
        expected.setRooms(List.of(living, kitchen, bathroom));
        expected.setSquareFeet(145);
        expected.setBiggest(living);
        expected.setPrice(116000);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(house);

        System.out.println(json);

        // Act
        this.mockMvc.perform(post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(json)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("$.biggest.name").value("Living"))
                .andExpect(jsonPath("$.squareFeet").value(145))
                .andExpect(jsonPath("$.price").value(116000));


    }
}
