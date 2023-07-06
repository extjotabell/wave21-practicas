package wave21.demoJPAHibernateSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wave21.demoJPAHibernateSpring.model.Joya;
import wave21.demoJPAHibernateSpring.service.IJoyaService;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private IJoyaService iJoyaService;

    @PostMapping("/jewelry/new")
    public ResponseEntity<?> createJoya(@RequestBody Joya joya){
        return iJoyaService.saveJoya(joya);
    }

    @GetMapping("/jewelry")
    public List<Joya> getJoyas (){
        return iJoyaService.getJoyas();
    }

    /*
    @PostMapping("/jewelry/update/{id}")
    public ResponseEntity<?> editJoya (@PathVariable long id,
                             @RequestParam ("name") String newName,
                             @RequestParam ("material") String newMaterial,
                             @RequestParam ("peso") Integer newPeso,
                             @RequestParam ("poseePiedra") Boolean newPoseePiedra){
        Joya joya = iJoyaService.findJoya(id);
        joya.setName(newName);
        joya.setMaterial(newMaterial);
        joya.setPeso(newPeso);
        joya.setPosee_piedra(newPoseePiedra);
        return iJoyaService.saveJoya(joya);
    }

     */

    @PostMapping("/jewelry/update/{id}")
    public ResponseEntity<?> editJoya(@PathVariable long id, @RequestBody Joya joyaData) {
        Joya joya = iJoyaService.findJoya(id);
        joya.setName(joyaData.getName());
        joya.setMaterial(joyaData.getMaterial());
        joya.setPeso(joyaData.getPeso());
        joya.setPosee_piedra(joyaData.getPosee_piedra());
        return iJoyaService.saveJoya(joya);
    }


    @PostMapping("/jewelry/delete/{id}")
    public ResponseEntity<?> deleteJoya (@PathVariable long id){
        return iJoyaService.deleteJoya(id);
    }
}
