package ru.vsu.cs.sazonov.faculty.app.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.sazonov.faculty.app.service.ExamService;
import ru.vsu.cs.sazonov.faculty.app.service.StudentExamService;
import ru.vsu.cs.sazonov.faculty.app.service.StudentService;
import ru.vsu.cs.sazonov.faculty.item.StudentExamRepository;
import ru.vsu.cs.sazonov.faculty.item.model.StudentExam;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentExamServiceImpl implements StudentExamService {

    private final ExamService examService;
    private final StudentService studentService;
    private final StudentExamRepository studentExamRepository;
    @Override
    public List<StudentExam> getExamOfStudent(Integer studentId) {
        List<StudentExam> exams = studentExamRepository.findByPkStudent(studentService.getStudent(studentId));
        return exams;
    }
}
