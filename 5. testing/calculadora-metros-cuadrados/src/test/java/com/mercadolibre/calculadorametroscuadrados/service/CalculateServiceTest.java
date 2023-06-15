package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CalculateServiceTest {
    @InjectMocks
    CalculateService calculateService;

    @Test
    @DisplayName("Calculate single room")
    void calculatevalid() {

        //Arrange
        RoomDTO roomKitchen = new RoomDTO();
        roomKitchen.setWidth(10);
        roomKitchen.setLength(10);
        roomKitchen.setName("Kitchen");
        ArrayList<RoomDTO> roomList = new ArrayList<>();
        roomList.add(roomKitchen);

        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("house1");
        houseDTO.setAddress("Fake street 123");
        houseDTO.setRooms(roomList);

        HouseResponseDTO expected = new HouseResponseDTO();
        expected.setBiggest(roomKitchen);
        expected.setPrice(100*800);
        expected.setRooms(roomList);
        expected.setName("house1");
        expected.setAddress("Fake street 123");
        expected.setSquareFeet(100);

        //Act
        HouseResponseDTO obtained = calculateService.calculate(houseDTO);

        //Assert
        Assertions.assertEquals(expected, obtained);
    }
    @Test
    @DisplayName("Calculate null room")
    void calculateinvalid() {

        //Arrange
        RoomDTO roomKitchen = new RoomDTO();
        roomKitchen.setWidth(10);
        roomKitchen.setLength(10);
        roomKitchen.setName("Kitchen");
        ArrayList<RoomDTO> roomList = new ArrayList<>();
        roomList.add(roomKitchen);

        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("house1");
        houseDTO.setAddress("Fake street 123");

        HouseResponseDTO expected = new HouseResponseDTO();
        expected.setBiggest(roomKitchen);
        expected.setPrice(100*800);
        expected.setName("house1");
        expected.setAddress("Fake street 123");
        expected.setSquareFeet(100);

        //Act
        HouseResponseDTO obtained = calculateService.calculate(houseDTO);

        //Assert
        Assertions.assertEquals(expected, obtained);
    }
}