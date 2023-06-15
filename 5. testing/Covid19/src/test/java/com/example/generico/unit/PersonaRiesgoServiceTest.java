package com.example.generico.unit;

import com.example.generico.DTO.PersonaRiesgoDTO;
import com.example.generico.DTO.response.PersonaRiesgoIdDTO;
import com.example.generico.DTO.response.PersonaRiesgoResponseDTO;
import com.example.generico.Exceptions.InternalErrorException;
import com.example.generico.entity.Persona;
import com.example.generico.entity.PersonaRiesgo;
import com.example.generico.entity.Sintoma;
import com.example.generico.repository.PersonaRepository;
import com.example.generico.repository.PersonaRiesgoRepository;
import com.example.generico.repository.SintomaRepository;
import com.example.generico.services.PersonaRiesgoService;
import com.example.generico.services.PersonaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PersonaRiesgoServiceTest {
  @Mock
  PersonaRepository personaRepository;
  @Mock
  PersonaRiesgoRepository personaRiesgoRepository;
  @Mock
  SintomaRepository sintomaRepository;

  @InjectMocks
  PersonaRiesgoService personaRiesgoService;

  @Test
  void buscarTodaslasPersonasRiesgoOk() {
    Persona nhdb = new Persona(1, "Nhdb", "de bellis", 90);
    Persona martin = new Persona(2, "Martin", "de bellis", 96);

    List<Sintoma> sintomas = List.of(
      new Sintoma(1, "DCOVID", "Dolor", 100),
      new Sintoma(2, "FCOVID", "Fiebre", 200)
    );

    List<PersonaRiesgo> danger = List.of(
      new PersonaRiesgo(nhdb, sintomas),
      new PersonaRiesgo(martin, List.of(sintomas.get(1)))
    );

    Mockito.when(personaRiesgoRepository.getAll()).thenReturn(danger);

    List<PersonaRiesgoResponseDTO> people =  personaRiesgoService.buscarPersonaRiesgo();

    Assertions.assertTrue(people
      .stream()
      .filter(p -> p.persona().nombre().equals(danger.get(1).getPersona().getNombre()))
      .allMatch(p -> p.sintomas().size()==1)
    );
  }

  @Test
  void buscarPersonasPorSintomasOk() {
    String sintoma = "Dolor";

    Persona nhdb = new Persona(1, "Nhdb", "de bellis", 90);
    Persona martin = new Persona(2, "Martin", "de bellis", 96);

    List<Sintoma> sintomas = List.of(
      new Sintoma(1, "DCOVID", "Dolor", 100),
      new Sintoma(2, "FCOVID", "Fiebre", 200)
    );

    List<PersonaRiesgo> personas = List.of(
      new PersonaRiesgo(nhdb, sintomas),
      new PersonaRiesgo(martin, List.of(sintomas.get(0)))
    );

    Mockito.when(personaRiesgoRepository.findBySintoma(sintoma)).thenReturn(personas);

    List<PersonaRiesgoResponseDTO> people =  personaRiesgoService.buscarPersonaRiesgo(sintoma);

    Assertions.assertAll(
      () -> Assertions.assertTrue(
        people
          .stream()
          .anyMatch(p -> personas.get(0).getPersona().getNombre().equals(p.persona().nombre()))
      ),
      () -> Assertions.assertTrue(
        people
          .stream()
          .anyMatch(p -> personas.get(1).getPersona().getNombre().equals(p.persona().nombre()))
      )
    );
  }

  @Test
  void crearPersonaRiesgoOk() {
    PersonaRiesgoDTO p = new PersonaRiesgoDTO(1, List.of(1, 2, 3));
    Optional<Persona> persona = Optional.of(new Persona(1, "", "", 70));
    List<Sintoma> sintomas = List.of(
      new Sintoma(1, "", "", 200),
      new Sintoma(2, "", "", 500),
      new Sintoma(3, "", "", 308)
    );

    PersonaRiesgo personaRiesgo = new PersonaRiesgo(persona.get(), sintomas);
    personaRiesgo.setId(1);

    Mockito.when(personaRepository.getByIdRiesgo(1)).thenReturn(persona);
    Mockito.when(sintomaRepository.obtenerSintomas(List.of(1, 2, 3))).thenReturn(sintomas);
    Mockito.when(personaRiesgoRepository.save(Mockito.any())).thenReturn(personaRiesgo);

    PersonaRiesgoIdDTO result = personaRiesgoService.crearPersonaRiesgo(p);

    Assertions.assertEquals(1, result.id());
  }

  @Test
  void crearPersonaRiesgoBadIdException() {

    PersonaRiesgoDTO p = new PersonaRiesgoDTO(1, List.of(1, 2, 3));

    Mockito.when(personaRepository.getByIdRiesgo(1)).thenReturn(Optional.empty());

    Assertions.assertThrows(InternalErrorException.class,  () -> personaRiesgoService.crearPersonaRiesgo(p));
  }

  @Test
  void crearPersonaRiesgoException() {
    PersonaRiesgoDTO p = new PersonaRiesgoDTO(1, List.of(1, 2, 3));
    Optional<Persona> persona = Optional.of(new Persona(1, "", "", 70));

    Mockito.when(personaRepository.getByIdRiesgo(1)).thenReturn(persona);
    Mockito.when(sintomaRepository.obtenerSintomas(List.of(1, 2, 3))).thenThrow(IndexOutOfBoundsException.class);


    Assertions.assertThrows(InternalErrorException.class, () -> personaRiesgoService.crearPersonaRiesgo(p));
  }
}
