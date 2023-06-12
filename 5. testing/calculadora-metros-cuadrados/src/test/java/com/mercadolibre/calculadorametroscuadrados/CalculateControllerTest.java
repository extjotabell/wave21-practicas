package com.mercadolibre.calculadorametroscuadrados;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateControllerTest {

@Autowired
MockMvc mockMvc;

@Test
public void calculateTest() throws Exception {

    HouseDTO house = new HouseDTO();
    List<RoomDTO> roomDTOList = new ArrayList<>();
    roomDTOList.add(new RoomDTO("Comedor",100,200));
    roomDTOList.add(new RoomDTO("Pieza 1",100,200));
    roomDTOList.add(new RoomDTO("Pieza 2",200,200));
    house.setName("Casita de prueba");
    house.setAddress("Calle falsa 123");
    house.setRooms(roomDTOList);

    HouseResponseDTO response = new HouseResponseDTO(house );
    ObjectWriter writer = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();

    String jsonPayload = writer.writeValueAsString(house);
    String responseJson = writer.writeValueAsString(response);

    mockMvc.perform(post("/calculate")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonPayload))
            .andDo(print())
            .andExpect(content().contentType("application/json"))
            .andExpect(m -> m.getResponse().getContentAsString().equals(responseJson));



}

}