package ru.vsu.cs.sazonov.faculty.app.service;

import org.springframework.data.domain.PageRequest;
import ru.vsu.cs.sazonov.faculty.item.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent(PageRequest pageRequest);
    List<Student> getAllStudent(String fullName, PageRequest pageRequest);

    Student getStudent(Integer studentId);

    Student createStudent(Student student);

    Student updateStudent(Student student);

    void deleteStudent(Integer studentId);

}
