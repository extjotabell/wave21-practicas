package wave21.CalculadoraDeCalorias.service;

import org.springframework.stereotype.Service;
import wave21.CalculadoraDeCalorias.repository.CaloriasRepository;

@Service
public class CaloriasService {
    private final CaloriasRepository repository;

    public CaloriasService(CaloriasRepository repository) {
        this.repository = repository;
    }
}
