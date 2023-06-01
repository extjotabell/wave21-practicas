package com.ejercicioAsincronico.EjercicioCovid19.Controllers;

import com.ejercicioAsincronico.EjercicioCovid19.Classes.Persona;
import com.ejercicioAsincronico.EjercicioCovid19.Classes.Sintoma;
import com.ejercicioAsincronico.EjercicioCovid19.DTOs.PersonaDTO;
import com.ejercicioAsincronico.EjercicioCovid19.DTOs.SintomaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/CentroSalud/")
public class CentrosSaludController {
    private List<Sintoma> sintomas = new ArrayList<>();
    private List<Persona> personas = new ArrayList<>();

    public CentrosSaludController() {
        // Generar Sintomas 10:
        generarSintomas();

        // Generar Personas 5:
        generarPersonas();

        asignarSintomas(2);
    }

    @GetMapping("findSymptoms")
    public ResponseEntity<List<SintomaDTO>> obtenerTodosLosSintomas(){
        List<SintomaDTO> sintomaDTOS = sintomas.stream()
                .map(sintoma -> new SintomaDTO(sintoma.getCodigo(), sintoma.getNombre(), sintoma.getNivelDeGravedad()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(sintomaDTOS);
    }

    @GetMapping("findSymptom/{name}")
    public ResponseEntity<String> obtenerNiverlGravedadPorNombre(@PathVariable String name){
        HttpStatus status = HttpStatus.OK;
        String resultado = "";

        Optional<Sintoma> sintoma = sintomas.stream()
                .filter(x -> x.getNombre().equalsIgnoreCase(name))
                .findFirst();

        if (sintoma.isPresent()){
            resultado = sintoma.get().getNivelDeGravedad();
        }
        else {
            status = HttpStatus.NOT_FOUND;
            resultado = "No existe gravedad para el nombre del sintoma enviado";
        }

        return ResponseEntity.status(status).body(resultado);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaDTO>> obtenerPersonasGrupoRiesgo() {
        List<PersonaDTO> personasGrupoRiesgo = personas.stream()
                .filter(persona -> persona.esMayor() && persona.tieneSintomas())
                .map(persona -> new PersonaDTO(persona.getNombre(), persona.getApellido(), persona.getEdad()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(personasGrupoRiesgo);
    }


    //region Metodos Privados
    private void generarPersonas() {
        for (int i = 1; i <= 5; i++) {
            Persona persona = new Persona();
            persona.setId(i);
            persona.setNombre("Persona" + i);
            persona.setApellido("Apellido" + i);
            persona.setEdad((int) (Math.random() * 100) + 1); // Generar edad aleatoria
            personas.add(persona);
        }
    }

    private void generarSintomas() {
        for (int i = 1; i <= 10; i++) {
            Sintoma sintoma = new Sintoma();
            sintoma.setCodigo("S - " + i);
            sintoma.setNombre("Sintoma" + i);
            sintoma.setNivelDeGravedad("Gravedad - " + i);
            sintomas.add(sintoma);
        }
    }

    private void asignarSintomas(int cantidad) {
        for (Persona persona: personas) {
            List<Sintoma> sintomasParaAsignar = sintomasAleatorios(cantidad);
            persona.setSintomas(sintomasParaAsignar);
        }
    }

    private List<Sintoma> sintomasAleatorios(int cantidad) {
        Collections.shuffle(sintomas);
        return sintomas.subList(0, cantidad);
    }
    //endregion
}
