package wave21.demoJPAHibernateSpring.service;

import org.springframework.stereotype.Service;
import wave21.demoJPAHibernateSpring.repository.IMiniserieRepository;

@Service
public class MiniSerieService {

    private final IMiniserieRepository studentRepository;

    public MiniSerieService(IMiniserieRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}
