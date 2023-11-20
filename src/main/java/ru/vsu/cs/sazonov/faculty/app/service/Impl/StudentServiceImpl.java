package ru.vsu.cs.sazonov.faculty.app.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vsu.cs.sazonov.faculty.app.exception.NotFoundException;
import ru.vsu.cs.sazonov.faculty.app.service.StudentService;
import ru.vsu.cs.sazonov.faculty.item.StudentRepository;
import ru.vsu.cs.sazonov.faculty.item.model.Student;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(Integer studentId) {
        return studentRepository.findById(studentId).orElseThrow(() -> new NotFoundException("Book with this id not found"));
    }

    @Override
    public Student createStudent(Student student) {
        return updateStudent(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.saveAndFlush(student);
    }

    @Override
    public void deleteStudent(Integer studentId) {
        studentRepository.deleteById(studentId);
    }
}
