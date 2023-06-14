package com.mercadolibre.calculadorametroscuadrados.unit;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CalculateServiceTest {
    private CalculateService service = new CalculateService();

    @Test
    @DisplayName("UT1 service - 1 m2 costs 800")
    public void calculatePriceOK(){
        //Arrange
        RoomDTO room = new RoomDTO("bedroom", 1, 1);
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(room);
        HouseDTO house = new HouseDTO("123", "Home", rooms);
        HouseResponseDTO expectedResponse = new HouseResponseDTO(house);
        expectedResponse.setPrice(800);
        expectedResponse.setSquareFeet(1);
        expectedResponse.setBiggest(room);
        //Act
        HouseResponseDTO response = service.calculate(house);
        //Assert
        Assertions.assertEquals(expectedResponse, response);
    }

    @Test
    @DisplayName("UT2 service - the middle room is the biggest")
    public void calculatePriceChanging(){
        //Arrange
        RoomDTO room = new RoomDTO("bedroom", 1, 1);
        RoomDTO room2 = new RoomDTO("bedroom2", 3, 1);
        RoomDTO room3 = new RoomDTO("bedroom3", 1, 2);

        List<RoomDTO> rooms = new ArrayList<>();
        Collections.addAll(rooms, room, room2, room3);
        HouseDTO house = new HouseDTO("123", "Home", rooms);
        HouseResponseDTO expectedResponse = new HouseResponseDTO(house);
        expectedResponse.setPrice(4800);
        expectedResponse.setSquareFeet(6);
        expectedResponse.setBiggest(room2);
        //Act
        HouseResponseDTO response = service.calculate(house);
        //Assert
        Assertions.assertEquals(expectedResponse, response);
    }

    @Test
    @DisplayName("UT3 service - the house is empty")
    public void calculateEmptyHouse(){
        //Arrange
        List<RoomDTO> rooms = new ArrayList<>();
        HouseDTO house = new HouseDTO("123", "Home", rooms);
        HouseResponseDTO expectedResponse = new HouseResponseDTO(house);
        expectedResponse.setPrice(0);
        expectedResponse.setSquareFeet(0);

        //Act
        HouseResponseDTO response = service.calculate(house);

        //Assert
        Assertions.assertEquals(expectedResponse, response);
    }

    



}
