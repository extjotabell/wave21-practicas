package wavew21.edadDeUnaPersona.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calcularEdadPorFecha")
public class edadDeUnaPersonaController {

    @GetMapping(path = "/{day}/{month}/{year}")
    public String calcularEdadPorFecha(@PathVariable int day, @PathVariable int month, @PathVariable int year){
        int currentDay = 31;
        int currentMonth = 5;
        int currentYear = 2023;

        int age = currentYear - year;

        if (currentMonth < month){
            age--;
        } else if (currentMonth == month && currentYear < year) {
            age--;
        }

        return "La edad es " + age;
    }
}
