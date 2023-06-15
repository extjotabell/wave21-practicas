package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CalculateServiceTest {

    private CalculateService _calculateService = new CalculateService();

    @Test
    @DisplayName("US0001 - Camino 1 metro cuadrado por costo 800")
    void calculatePriceTest(){

        //Arrange
        RoomDTO room = new RoomDTO("bedroom",1,1);
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(room);
        HouseDTO house = new HouseDTO("123456","Home",rooms);
        HouseResponseDTO expectedResult = new HouseResponseDTO(house);
        expectedResult.setPrice(800);
        expectedResult.setSquareFeet(1);
        expectedResult.setBiggest(room);

        //Act
        HouseResponseDTO currentResult = _calculateService.calculate(house);

        //Assert
        Assertions.assertEquals(expectedResult, currentResult);
    }

    @Test
    @DisplayName("US0002 - Camino de la habitación con las mayores dimensiones")
    void calculateBiggerRoomTest(){

        //Arrange
        RoomDTO room1 = new RoomDTO("bedroom1",1,1);
        RoomDTO room2 = new RoomDTO("bedroom2",3,1);
        RoomDTO room3 = new RoomDTO("bedroom3",1,2);
        List<RoomDTO> rooms = new ArrayList<>();
        Collections.addAll(rooms, room1, room2, room3);
        HouseDTO house = new HouseDTO("123456","Home",rooms);
        HouseResponseDTO expectedResult = new HouseResponseDTO(house);
        expectedResult.setPrice(4800);
        expectedResult.setSquareFeet(6);
        expectedResult.setBiggest(room2);

        //Act
        HouseResponseDTO currentResult = _calculateService.calculate(house);

        //Assert
        Assertions.assertEquals(expectedResult, currentResult);

    }

    @Test
    @DisplayName("US0003 - Camino de la casa esta vacia")
    void calculateEmptyHouseTest(){

        //Arrange
        List<RoomDTO> rooms = new ArrayList<>();
        HouseDTO house = new HouseDTO("123456","Home",rooms);
        HouseResponseDTO expectedResult = new HouseResponseDTO(house);
        expectedResult.setPrice(0);
        expectedResult.setSquareFeet(0);

        //Act
        HouseResponseDTO currentResult = _calculateService.calculate(house);

        //Assert
        Assertions.assertEquals(expectedResult, currentResult);

    }

}
