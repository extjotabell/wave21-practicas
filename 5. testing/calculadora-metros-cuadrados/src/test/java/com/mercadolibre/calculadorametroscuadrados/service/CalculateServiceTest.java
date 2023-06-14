package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CalculateServiceTest {
    CalculateService service = new CalculateService();

    @Test
    void calculate() {
        // arrange
        RoomDTO living = new RoomDTO("Living", 10, 10);
        RoomDTO kitchen = new RoomDTO("Kitchen", 7, 5);
        RoomDTO bathroom = new RoomDTO("Bathroom", 5, 2);

        HouseDTO house = new HouseDTO("House", "Address", List.of(living, kitchen, bathroom) );

        HouseResponseDTO expected = new HouseResponseDTO();
        expected.setName("House");
        expected.setAddress("Address");
        expected.setRooms(List.of(living, kitchen, bathroom));
        expected.setSquareFeet(145);
        expected.setBiggest(living);
        expected.setPrice(116000);

        // act
        HouseResponseDTO result = service.calculate(house);

        // assert
        Assertions.assertEquals(expected.getName(), result.getName());
        Assertions.assertEquals(expected.getAddress(), result.getAddress());
        Assertions.assertEquals(expected.getRooms(), result.getRooms());
        Assertions.assertEquals(expected.getSquareFeet(), result.getSquareFeet());
        Assertions.assertEquals(expected.getBiggest(), result.getBiggest());
        Assertions.assertEquals(expected.getPrice(), result.getPrice());
    }
}
