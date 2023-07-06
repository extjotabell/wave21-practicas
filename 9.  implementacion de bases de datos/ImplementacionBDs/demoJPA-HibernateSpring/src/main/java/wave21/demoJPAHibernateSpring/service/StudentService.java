package wave21.demoJPAHibernateSpring.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import wave21.demoJPAHibernateSpring.model.Student;
import wave21.demoJPAHibernateSpring.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    private final StudentRepository stuRepo;

    public StudentService(StudentRepository studentRepository) {
        this.stuRepo = studentRepository;
    }

    @Override
    @Transactional
    public List<Student> getStudents() {
        return stuRepo.findAll();
    }

    @Override
    @Transactional
    public void saveStudent(Student stu) {
        stuRepo.save(stu);
    }

    @Override
    @Transactional
    public void deleteStudent(Long id) {
        stuRepo.deleteById(id);
    }

    @Override
    @Transactional
    public Student findStudent(Long id) {
        return stuRepo.findById(id).orElse(null);
    }
}
