package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerTest {
    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
    }

    @Test
    @DisplayName("CalculateOneRoom Integration Test")
    void calculateOneRoom() throws Exception{
        HouseDTO house = new HouseDTO("Oficina", "Monroe 800",
                List.of(new RoomDTO("Espacio Abierto", 3, 3)));

        String expected = writer.writeValueAsString(house);

        this.mockMvc.perform(
                        post("/calculate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(expected))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.squareFeet").value(9));

    }

    @Test
    @DisplayName("CalculateManyRooms Integration Test")
    void calculateManyRooms() throws Exception{
        HouseDTO house = new HouseDTO("Oficina", "Monroe 800",
                List.of(new RoomDTO("Espacio Abierto", 5, 5),
                        new RoomDTO("Cocina", 3, 3),
                        new RoomDTO("Baño", 2, 1)));

        String expected = writer.writeValueAsString(house);

        this.mockMvc.perform(
                        post("/calculate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(expected))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.squareFeet").value(36));
    }

    @Test
    @DisplayName("CalculatePrice Integration Test")
    void calculatePrice() throws Exception{
        HouseDTO house = new HouseDTO("Oficina", "Monroe 800",
                List.of(new RoomDTO("Espacio Abierto", 5, 5),
                        new RoomDTO("Cocina", 3, 3),
                        new RoomDTO("Baño", 2, 1)));

        String expected = writer.writeValueAsString(house);

        this.mockMvc.perform(
                        post("/calculate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(expected))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(28800));
    }

    @Test
    @DisplayName("CalculateBiggestRoom Integration Test")
    void calculateBiggestRoom() throws Exception{
        HouseDTO house = new HouseDTO("Oficina", "Monroe 800",
                List.of(new RoomDTO("Espacio Abierto", 5, 5),
                        new RoomDTO("Cocina", 3, 3),
                        new RoomDTO("Baño", 2, 1)));

        String expected = writer.writeValueAsString(house);

        this.mockMvc.perform(
                        post("/calculate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(expected))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.biggest.name").value("Espacio Abierto"));
    }

    @Test
    @DisplayName("CalculateRoomsSize Integration Test")
    void calculateRoomsSize() throws Exception{
        HouseDTO house = new HouseDTO("Oficina", "Monroe 800",
                List.of(new RoomDTO("Espacio Abierto", 5, 5),
                        new RoomDTO("Cocina", 3, 3),
                        new RoomDTO("Baño", 2, 1)));

        String expected = writer.writeValueAsString(house);

        this.mockMvc.perform(
                        post("/calculate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(expected))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.rooms[0].squareFeet").value(25))
                .andExpect(jsonPath("$.rooms[1].squareFeet").value(9))
                .andExpect(jsonPath("$.rooms[2].squareFeet").value(2));
    }


}
