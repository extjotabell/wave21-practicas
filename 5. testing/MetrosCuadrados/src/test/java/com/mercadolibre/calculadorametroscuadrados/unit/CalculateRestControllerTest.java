package com.mercadolibre.calculadorametroscuadrados.unit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(MockitoExtension.class)

public class CalculateRestControllerTest {
    @Mock
    CalculateService service;

    @InjectMocks
    CalculateRestController controller;

    @Test
    @DisplayName("CalculateTest ok Unit Test")
    void calculateTest(){
        List<RoomDTO> rooms = new ArrayList<>();
        RoomDTO room = new RoomDTO("room", 2,2 );
        rooms.add(room);
        HouseDTO house = new HouseDTO("house", "house", rooms);

        HouseResponseDTO expected = new HouseResponseDTO(house);
        expected.setSquareFeet(4);
        expected.setBiggest(room);
        expected.setPrice(3200);

        Mockito.lenient().when(service.calculate(house))
                .thenReturn(expected);
        HouseResponseDTO response  = controller.calculate(house);

        assertEquals(response, expected);
    }
}
