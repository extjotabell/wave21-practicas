package wave21.CalculadoraDeCalorias.controller;

import org.springframework.web.bind.annotation.RestController;
import wave21.CalculadoraDeCalorias.service.CaloriasService;

@RestController
public class CaloriasController {
    private final CaloriasService service;

    public CaloriasController(CaloriasService service) {
        this.service = service;
    }


}
