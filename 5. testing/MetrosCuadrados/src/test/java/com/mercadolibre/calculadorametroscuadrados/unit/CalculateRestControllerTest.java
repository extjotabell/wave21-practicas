package com.mercadolibre.calculadorametroscuadrados.unit;

import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


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

        Mockito.when(service.calculate(house))
                .thenReturn(expected);
        HouseResponseDTO response  = controller.calculate(house);

        assertEquals(response, expected);
    }
}
