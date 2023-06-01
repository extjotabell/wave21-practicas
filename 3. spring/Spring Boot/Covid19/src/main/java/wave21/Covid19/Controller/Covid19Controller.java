package wave21.Covid19.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import wave21.Covid19.DTO.PersonaFullNameDTO;
import wave21.Covid19.DTO.SintomaResponseDTO;
import wave21.Covid19.DTO.SintomaSeverityDTO;
import wave21.Covid19.Service.Covid19Service;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class Covid19Controller {

    Covid19Service service;

    public Covid19Controller(Covid19Service service){
        this.service = service;
    }

    @GetMapping(path = "/findSymptom")
    public ResponseEntity<List<SintomaResponseDTO>> viewSymptoms(){
        return new ResponseEntity<>(service.viewSymptoms(),OK);
    }

    @GetMapping(path = "/findSymptom/{name}")
    public ResponseEntity<SintomaSeverityDTO> getSymptomLevel(@PathVariable String name){
        return new ResponseEntity<SintomaSeverityDTO>(service.getSymptomLevel(name),HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/findRiskPerson")
    public ResponseEntity<List<PersonaFullNameDTO>> findRiskPerson(){
        return new ResponseEntity<List<PersonaFullNameDTO>>(service.findRiskPerson(),HttpStatus.NOT_FOUND);
    }
}
