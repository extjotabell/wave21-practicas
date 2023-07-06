package wave21.demoJPAHibernateSpring.service;

import wave21.demoJPAHibernateSpring.model.Student;

import java.util.List;

public interface IStudentService {
    public List<Student> getStudents();
    public void saveStudent (Student stu);
    public void deleteStudent (Long id);
    public Student findStudent (Long id);
}
