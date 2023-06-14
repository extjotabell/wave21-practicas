package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CalculateServiceTest {

    @InjectMocks
    @Spy
    CalculateService underTest;

    HouseDTO houseDTOMock;

    HouseResponseDTO houseResponseDTOMock;

    @BeforeEach
    void setUp() {
        houseDTOMock=mockHouseDTO();
        houseResponseDTOMock=mockHouseResponseDTO();
    }

    @Test
    void testHouseDTOConstructor(){
        houseDTOMock=new HouseDTO();

        assertNotNull(houseDTOMock);
    }

    @Test
    void testHouseResponseDTOConstructor(){
        houseResponseDTOMock=new HouseResponseDTO();

        assertNotNull(houseResponseDTOMock);
    }

    @Test
    void calculate() {
        HouseResponseDTO houseResponseDTOResponse = underTest.calculate(houseDTOMock);

        Integer expectedTotalSquare= 1100;
        Integer expectedBiggest=600;
        Integer expectedPrice= expectedTotalSquare*800;

        assertEquals(houseResponseDTOResponse.getSquareFeet(),expectedTotalSquare);
        assertEquals(houseResponseDTOResponse.getBiggest().getLength()*houseResponseDTOResponse.getBiggest().getWidth(),expectedBiggest);
        assertEquals(houseResponseDTOResponse.getPrice(),expectedPrice);
    }

    private HouseDTO mockHouseDTO(){
        return new HouseDTO("Tomorrowland","New York 2131", Arrays.asList(new RoomDTO("Bathroom",30,20),new RoomDTO("Bedroom",25,20)));
    }

    private HouseResponseDTO mockHouseResponseDTO(){
        return new HouseResponseDTO(houseDTOMock);
    }
}