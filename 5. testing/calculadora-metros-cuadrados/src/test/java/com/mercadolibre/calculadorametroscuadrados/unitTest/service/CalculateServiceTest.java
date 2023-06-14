package com.mercadolibre.calculadorametroscuadrados.unitTest.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class CalculateServiceTest {

    CalculateService calculateService = new CalculateService();

    @Test
    void calculateHouseWithOneRoom(){

        HouseDTO houseDTO = new HouseDTO("Oficina","Monroe 80", Arrays.asList(new RoomDTO("Espacio abierto",3,3)));

        HouseResponseDTO result = calculateService.calculate(houseDTO);

        int expectedResult = 9;

        assertEquals(expectedResult,result.getSquareFeet());

    }

    @Test
    void calculateHouseWithMultipleRoom() {
        HouseDTO houseDTO = new HouseDTO("Oficina","Monroe 80", Arrays.asList(new RoomDTO("Espacio abierto",5,5),
                                                                                            new RoomDTO("Cocina",3,3),
                                                                                            new RoomDTO("Baño",2,1)));

        HouseResponseDTO result = calculateService.calculate(houseDTO);

        int expectedResult = 36;

        assertEquals(expectedResult,result.getSquareFeet());
    }

    @Test
    void calculateHousePrice(){

        HouseDTO houseDTO = new HouseDTO("Oficina","Monroe 80", Arrays.asList(new RoomDTO("Espacio abierto",5,5),
                                                                                            new RoomDTO("Cocina",3,3),
                                                                                            new RoomDTO("Baño",2,1)));

        HouseResponseDTO result = calculateService.calculate(houseDTO);

        int expectedResult = 28800;

        assertEquals(expectedResult,result.getPrice());

    }

    @Test
    void calculateBiggestRoom(){

        HouseDTO houseDTO = new HouseDTO("Oficina","Monroe 80", Arrays.asList(new RoomDTO("Espacio abierto",5,5),
                                                                                            new RoomDTO("Cocina",3,3),
                                                                                            new RoomDTO("Baño",2,1)));

        HouseResponseDTO result = calculateService.calculate(houseDTO);

        String expectedResult = "Espacio abierto";

        assertEquals(expectedResult,result.getBiggest().getName());

    }

    @Test
    void calculateRoomsSquareFeet(){

        HouseDTO houseDTO = new HouseDTO("Oficina","Monroe 80", Arrays.asList(new RoomDTO("Espacio abierto",5,5),
                                                                                            new RoomDTO("Cocina",3,3),
                                                                                            new RoomDTO("Baño",2,1)));

        List<RoomDTO> result = calculateService.calculate(houseDTO).getRooms();

        List<Integer> expectedResult = Arrays.asList(25,9,2);
        List<Integer> actual = new ArrayList<>();

        for (RoomDTO item: result) {
            actual.add(item.getSquareFeet());
        }

        assertEquals(expectedResult,actual);

    }

}
