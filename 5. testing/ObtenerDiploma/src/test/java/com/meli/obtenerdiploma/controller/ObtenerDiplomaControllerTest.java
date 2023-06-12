package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ObtenerDiplomaControllerTest {
    @Mock
    IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    @DisplayName("Analizar puntaje")
    void analizarPuntajeTest() {
        StudentDTO studentMock = new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de " + 0 + ". Felicitaciones!", 0D, null);

        when(obtenerDiplomaService.analyzeScores(1L)).thenReturn(studentMock);

        Assertions.assertEquals(studentMock, obtenerDiplomaController.analyzeScores(1L));
    }
}
