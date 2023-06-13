package com.mercadolibre.calculadorametroscuadrados.integrationtest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateTest {
    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .writer();

    @Test
    public void calculateTest() throws Exception {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setName("Presidential");
        roomDTO.setLength(30);
        roomDTO.setWidth(50);

        List<RoomDTO> rooms = List.of(roomDTO);

        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setAddress("#");
        houseDTO.setName("Casa");
        houseDTO.setRooms(rooms);

        HouseResponseDTO houseResponseDTO = new HouseResponseDTO(houseDTO);
        houseResponseDTO.setPrice(1200000);
        houseResponseDTO.setSquareFeet(1500);
        houseResponseDTO.setBiggest(roomDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(houseDTO))).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(writer.writeValueAsString(houseResponseDTO)));
    }
}
