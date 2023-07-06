package wave21.demoJPAHibernateSpring.service;

import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import wave21.demoJPAHibernateSpring.model.Joya;
import wave21.demoJPAHibernateSpring.repository.JoyaRepository;

import java.util.List;

@Service
public class JoyaService implements IJoyaService {

    private final JoyaRepository joyaRepository;

    public JoyaService(JoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
    }

    @Override
    @Transactional
    public List<Joya> getJoyas() {
        return joyaRepository.findAll();
    }

    @Override
    @Transactional
    public ResponseEntity<?> saveJoya(Joya joya) {
        joya.setVentaONo(true);
        joyaRepository.save(joya);
        return ResponseEntity.ok("Joya nro " + joya.getId() + " guardada con éxtio");
    }

    @Override
    @Transactional
    public ResponseEntity<?> deleteJoya(Long id) {
        if(joyaRepository.existsById(id)){
            joyaRepository.deleteById(id);
            return ResponseEntity.ok("Joya nro " + id + " eliminada con éxtio");
        }else{
            return ResponseEntity.ok("Joya nro " + id + " no existe.");

        }

    }

    @Override
    @Transactional
    public Joya findJoya(Long id) {
        return joyaRepository.findById(id).orElse(null);
    }
}
