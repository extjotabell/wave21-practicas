package com.mercadolibre.calculadorametroscuadrados;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CalculateServiceTest {

    @Autowired
    CalculateService service;

    @Test
    @DisplayName("ESC 001 -Verificar que el valor de la propiedad es de 64M")
    void calcularValorPropiedadTest(){
    int valorPropiedad = 64000000;
    HouseDTO house = new HouseDTO();
    List<RoomDTO> roomDTOList = new ArrayList<>();
    roomDTOList.add(new RoomDTO("Comedor",100,200));
    roomDTOList.add(new RoomDTO("Pieza 1",100,200));
    roomDTOList.add(new RoomDTO("Pieza 2",200,200));
    house.setName("Casita de prueba");
    house.setAddress("Calle falsa 123");
    house.setRooms(roomDTOList);
    HouseResponseDTO response = service.calculate(house);
    assertEquals(valorPropiedad,response.getPrice());

    }
    @Test
    @DisplayName("ESC 002 -Verificar que la pieza 2 es el ambiente mas grande")
    void calcularDimensionDelCuartoTest(){
        RoomDTO piezaMasGrande = new RoomDTO("Pieza 2",200,200);
        HouseDTO house = new HouseDTO();
        List<RoomDTO> roomDTOList = new ArrayList<>();
        roomDTOList.add(new RoomDTO("Comedor",100,200));
        roomDTOList.add(new RoomDTO("Pieza 1",100,200));
        roomDTOList.add(new RoomDTO("Pieza 2",200,200));
        house.setName("Casita de prueba");
        house.setAddress("Calle falsa 123");
        house.setRooms(roomDTOList);
        HouseResponseDTO response = service.calculate(house);
        assertEquals(piezaMasGrande,response.getBiggest());

    }

    @Test
    @DisplayName("ESC 003 -Verificar la dimension de todos los ambientes ")
    void calcularM2PorPiezaTest(){
        int dimension1 = 20000;
        int dimension2 = 40000;
        HouseDTO house = new HouseDTO();
        List<RoomDTO> roomDTOList = new ArrayList<>();
        roomDTOList.add(new RoomDTO("Comedor",100,200));
        roomDTOList.add(new RoomDTO("Pieza 1",100,200));
        roomDTOList.add(new RoomDTO("Pieza 2",200,200));
        house.setName("Casita de prueba");
        house.setAddress("Calle falsa 123");
        house.setRooms(roomDTOList);
        HouseResponseDTO response = service.calculate(house);
        assertEquals(dimension1,response.getRooms().get(0).getSquareFeet());
        assertEquals(dimension1,response.getRooms().get(1).getSquareFeet());
        assertEquals(dimension2,response.getRooms().get(2).getSquareFeet());

    }
}
