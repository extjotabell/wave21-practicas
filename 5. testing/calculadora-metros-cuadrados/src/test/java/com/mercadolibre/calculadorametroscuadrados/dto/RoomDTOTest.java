package com.mercadolibre.calculadorametroscuadrados.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomDTOTest {

    @Test
    @DisplayName("Obtain squarefeet valid")
    void getSquareFeet() {

        //Arrange
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setLength(10);
        roomDTO.setWidth(10);

        Integer expected = 100;

        //Act
        Integer obtained = roomDTO.getSquareFeet();

        //Assert
        Assertions.assertEquals(expected, obtained);
    }
    @Test
    @DisplayName("Obtain squearefeet null size")
    void getSquareFeetnull() {

        //Arrange
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setWidth(10);

        Integer expected = 0;

        //Act
        Integer obtained = roomDTO.getSquareFeet();

        //Assert
        Assertions.assertEquals(expected, obtained);
    }
}