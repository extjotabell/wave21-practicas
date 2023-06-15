package com.mercadolibre.calculadorametroscuadrados.controller.unitary;

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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



//@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTestUnit {

    @Mock
    CalculateService _calculateService;

    @InjectMocks
    CalculateRestController _calculateRestController;

    @Test
    @DisplayName("US0001 - Camino ok Calculate")
    void calculateTestOk() {

        //Arrange
        List<RoomDTO> rooms = new ArrayList<>();
        RoomDTO room = new RoomDTO("bedroom", 2, 2);
        rooms.add(room);

        HouseDTO house = new HouseDTO("Home", "Home", rooms);
        HouseResponseDTO expectedResult = new HouseResponseDTO(house);

        expectedResult.setPrice(3200);
        expectedResult.setSquareFeet(4);
        expectedResult.setBiggest(room);

        Mockito.lenient().when(_calculateService.calculate(house)).thenReturn(expectedResult);

        //Act
        HouseResponseDTO currentResult = _calculateRestController.calculate(house);

        //Assert
        assertEquals(currentResult, expectedResult);
    }

}
