package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CalculateServiceTest {

    @InjectMocks
    CalculateService calculateService;

    @Test
    public void setCalculateServiceTest() {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setName("Presidential");
        roomDTO.setLength(30);
        roomDTO.setWidth(50);

        List<RoomDTO> rooms = List.of(roomDTO);

        // Request
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("Casa");
        houseDTO.setRooms(rooms);
        houseDTO.setAddress("#");

        // Expected
        HouseResponseDTO houseResponseDTO = new HouseResponseDTO(houseDTO);

        HouseResponseDTO result = calculateService.calculate(houseDTO);
        assertSame(houseResponseDTO.getName(),result.getName());
    }
}
