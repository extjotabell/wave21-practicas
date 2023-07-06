package wave21.demoJPAHibernateSpring.service;

import org.springframework.stereotype.Service;
import wave21.demoJPAHibernateSpring.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}
