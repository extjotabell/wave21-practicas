package wave21.Covid19.Service;

import org.springframework.stereotype.Service;
import wave21.Covid19.DTO.PersonaFullNameDTO;
import wave21.Covid19.DTO.SintomaResponseDTO;
import wave21.Covid19.DTO.SintomaSeverityDTO;
import wave21.Covid19.Model.Persona;
import wave21.Covid19.Model.PersonaConSintoma;
import wave21.Covid19.Model.Sintoma;
import wave21.Covid19.Repository.Covid19Repository;

import java.util.List;

@Service
public class Covid19Service {
    Covid19Repository repository;

    public Covid19Service(Covid19Repository repository) {
        this.repository = repository;
    }

    public List<SintomaResponseDTO> viewSymptoms(){
        //traigo del repo la lista de sintomas del modelo
        List<Sintoma> sintomas = repository.getSintomas();
        //Convierto el modelo a DTO
        List<SintomaResponseDTO> sintomasDTO = sintomas
                .stream()
                .map(sintoma -> {
                    SintomaResponseDTO sintomaDTO = new SintomaResponseDTO();
                    sintomaDTO.setCode(sintoma.getCodigo());
                    sintomaDTO.setName(sintoma.getNombre());
                    sintomaDTO.setSeverityLevel(sintoma.getNivelDeGravedad().toString());
                    return sintomaDTO;
                })
                .toList();
        return sintomasDTO;
    }

    public SintomaSeverityDTO getSymptomLevel(String name){
        Sintoma sintoma = repository.findSintomaByName(name);
        SintomaSeverityDTO severityDTO = new SintomaSeverityDTO();
        severityDTO.setSeverityLevel(sintoma.getNivelDeGravedad().toString());
        return severityDTO;
    }

    public List<PersonaFullNameDTO> findRiskPerson(){
        List<PersonaConSintoma> grupoDeRiesgo = repository.findRiskPersonas();
        List<PersonaFullNameDTO> personas = grupoDeRiesgo
                .stream()
                .map(PersonaConSintoma -> {
                    Persona p = new Persona();
                    p = repository.findPersonaPorId(PersonaConSintoma.getIdPersona());
                    PersonaFullNameDTO personaDTO = new PersonaFullNameDTO();
                    personaDTO.setName(p.getNombre());
                    personaDTO.setLastName(p.getApellido());
                    return personaDTO;
                })
                .toList();
        return personas;
    }

}
