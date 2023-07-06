package wave21.demoJPAHibernateSpring.service;

import org.springframework.http.ResponseEntity;
import wave21.demoJPAHibernateSpring.model.Joya;

import java.util.List;

public interface IJoyaService {
    public List<Joya> getJoyas();
    public ResponseEntity<?> saveJoya (Joya stu);
    public ResponseEntity<?> deleteJoya (Long id);
    public Joya findJoya (Long id);
}
