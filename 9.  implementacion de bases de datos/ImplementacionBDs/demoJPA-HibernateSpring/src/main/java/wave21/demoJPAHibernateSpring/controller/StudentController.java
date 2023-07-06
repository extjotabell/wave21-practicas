package wave21.demoJPAHibernateSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wave21.demoJPAHibernateSpring.model.Student;
import wave21.demoJPAHibernateSpring.repository.StudentRepository;
import wave21.demoJPAHibernateSpring.service.IStudentService;
import wave21.demoJPAHibernateSpring.service.StudentService;

import java.util.List;

public class StudentController {

    @Autowired
    private IStudentService iStudentService;

    @PostMapping("/create")
    public String createStudent(@RequestBody Student student){
        iStudentService.saveStudent(student);
        return "El estudiante fue agregado correctamente.";
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return iStudentService.getStudents();
    }

    @PostMapping("/edit/{id}")
    public Student editStudent (@PathVariable long id,
                                @RequestParam ("name") String newName,
                                @RequestParam ("lastname") String newLastname){
        Student stu = iStudentService.findStudent(id);
        stu.setName(newName);
        stu.setApellido(newLastname);
        iStudentService.saveStudent(stu);
        return stu;
    }

    @PostMapping
    public String deleteStudent (@PathVariable long id){
        iStudentService.deleteStudent(id);
        return "El estudiante fue borrado correctamente.";
    }
}
