package wave21.Covid19.Repository;

import lombok.Getter;
import org.springframework.stereotype.Repository;
import wave21.Covid19.Model.Persona;
import wave21.Covid19.Model.PersonaConSintoma;
import wave21.Covid19.Model.Sintoma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
@Getter
public class Covid19Repository {
    private List<Persona> personas;
    private List<Sintoma> sintomas;
    private List<PersonaConSintoma> grupoDeRiesgo;
    public Covid19Repository() {
        personas = new ArrayList<>();
        sintomas = new ArrayList<>();
        grupoDeRiesgo = new ArrayList<>();
        initData();
    }

    private void initData(){
        personas.add(new Persona("1", "Javier", "Rydel", 24));
        personas.add(new Persona("2", "Marcelo", "Perez", 30));
        personas.add(new Persona("3", "Fabian", "Fernandez", 61));
        sintomas.add((new Sintoma("1", "Gripe", 1)));
        sintomas.add((new Sintoma("2", "Sinusitis", 2)));
        sintomas.add((new Sintoma("3", "Fiebre", 3)));
        grupoDeRiesgo.add(new PersonaConSintoma("1", Arrays.asList("1","2") ));
        grupoDeRiesgo.add(new PersonaConSintoma("2", Arrays.asList("2","3") ));
        grupoDeRiesgo.add(new PersonaConSintoma("3", Arrays.asList("3") ));
    }

    public Sintoma findSintomaByName(String name){
        Sintoma sintoma = sintomas.stream()
                .filter(s -> s.getNombre().equals(name))
                .findFirst()
                .orElse(null);
        return sintoma;
    }

    public List<PersonaConSintoma> findRiskPersonas(){
        List<PersonaConSintoma> riesgosos = new ArrayList<>();
        for(PersonaConSintoma p : getGrupoDeRiesgo()){
            Persona personadeRiesgo = findPersonaPorId(p.getIdPersona());
            if(personadeRiesgo.getEdad() > 60 && p.getSintomas().size() >= 1){
                riesgosos.add(p);
            }
        }
        return riesgosos;
    }

    public Persona findPersonaPorId(String id){
        for(Persona persona : personas){
            if (persona.getId().equals(id)){
                return persona;
            }
        }
        return null;
    }
}
