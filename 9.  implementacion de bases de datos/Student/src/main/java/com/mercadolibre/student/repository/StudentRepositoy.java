package com.mercadolibre.student.repository;

import com.mercadolibre.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepositoy extends JpaRepository<Student, Long> {
}
