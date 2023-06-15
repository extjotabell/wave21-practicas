package com.meli.obtenerdiploma.unit.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ObtenerDiplomaServiceTestSinMock {

    @Autowired
    ObtenerDiplomaService diplomaService;

    @Test
    @DisplayName("")
    public void analyzeScoresOk() throws JsonProcessingException{
        //Arrange

        //Act
        //Assert
    }


    @Test
    @DisplayName("")
    public void analyzeScoresNoOk() throws JsonProcessingException{

    }
}
