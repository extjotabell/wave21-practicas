package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTest {

    @Mock
    CalculateService calculateService;

    @InjectMocks
    CalculateRestController controller;

    @Test
    public void calculateTest() {
        // Arrange
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setName("Presidential");
        roomDTO.setLength(30);
        roomDTO.setWidth(50);

        List<RoomDTO> rooms = List.of(roomDTO);
        HouseResponseDTO houseResponseDTO = new HouseResponseDTO();
        houseResponseDTO.setRooms(rooms);
        houseResponseDTO.setBiggest(rooms.get(0));
        houseResponseDTO.setPrice(2000);
        houseResponseDTO.setSquareFeet(80);
        houseResponseDTO.setAddress("#");
        houseResponseDTO.setName("Happy House");

        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setRooms(rooms);
        houseDTO.setAddress("#");
        houseDTO.setName("Happy House");

        // Assert
        assertEquals(controller.calculate(houseDTO).getName(),houseResponseDTO.getName());
    }
}
