package com.example.generico.unit;

import com.example.generico.DTO.PersonaDTO;
import com.example.generico.DTO.response.PersonaIdDTO;
import com.example.generico.entity.Persona;
import com.example.generico.repository.PersonaRepository;
import com.example.generico.services.PersonaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PersonaServiceTest {
  @Mock
  PersonaRepository personaRepository;

  @InjectMocks
  PersonaService personaService;

  @Test
  void savePersonOk() {
    PersonaDTO p = new PersonaDTO("Nhdb", "de bellis", 10);

    Persona persona = new Persona();
    persona.setId(1);
    Mockito.when(personaRepository.save(Mockito.any())).thenReturn(persona);

    PersonaIdDTO resultPerson = personaService.crearPersona(p);

    Assertions.assertEquals(1, resultPerson.id());
  }
}
