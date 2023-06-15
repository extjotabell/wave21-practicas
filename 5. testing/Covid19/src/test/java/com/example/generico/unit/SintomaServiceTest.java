package com.example.generico.unit;

import com.example.generico.DTO.PersonaRiesgoDTO;
import com.example.generico.DTO.SintomaDTO;
import com.example.generico.DTO.SintomaIdDTO;
import com.example.generico.DTO.response.PersonaRiesgoIdDTO;
import com.example.generico.DTO.response.SintomaResponseDTO;
import com.example.generico.Exceptions.InternalErrorException;
import com.example.generico.entity.Persona;
import com.example.generico.entity.PersonaRiesgo;
import com.example.generico.entity.Sintoma;
import com.example.generico.repository.SintomaRepository;
import com.example.generico.services.SintomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class SintomaServiceTest {

  @Mock
  SintomaRepository sintomaRepository;

  @InjectMocks
  SintomaService sintomaService;

  @Test
  void crearSintomaOk() {
    Sintoma sintoma = new Sintoma(1, "", "", 200);

    Mockito.when(sintomaRepository.save(Mockito.any())).thenReturn(sintoma);

    SintomaIdDTO result = sintomaService.crearSintoma(new SintomaDTO(sintoma));

    Assertions.assertEquals(1, result.id());
  }

  @Test
  void buscarSintomaOk() {
    String sintoma = "";
    Sintoma sintomas = new Sintoma(1, "DCOV", "", 200);

    Mockito.when(sintomaRepository.getByName(sintoma)).thenReturn(Optional.of(sintomas));

    SintomaResponseDTO result = sintomaService.buscarSintoma(sintoma);

    Assertions.assertEquals(1, result.id());
    Assertions.assertEquals("DCOV", result.codigo());
  }

  @Test
  void buscarSintomaException() {
    String sintoma = "";

    Mockito.when(sintomaRepository.getByName(sintoma)).thenReturn(Optional.empty());

    Assertions.assertThrows(InternalErrorException.class, () -> sintomaService.buscarSintoma(sintoma));

  }
}
