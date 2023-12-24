package ru.vsu.cs.sazonov.faculty.app.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.sazonov.faculty.app.exception.NotFoundException;
import ru.vsu.cs.sazonov.faculty.app.service.ExamService;
import ru.vsu.cs.sazonov.faculty.app.service.StudentExamService;
import ru.vsu.cs.sazonov.faculty.app.service.StudentService;
import ru.vsu.cs.sazonov.faculty.item.StudentExamRepository;
import ru.vsu.cs.sazonov.faculty.item.model.Exam;
import ru.vsu.cs.sazonov.faculty.item.model.Student;
import ru.vsu.cs.sazonov.faculty.item.model.StudentExam;
import ru.vsu.cs.sazonov.faculty.item.model.StudentExamPK;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentExamServiceImpl implements StudentExamService {

    private final ExamService examService;
    private final StudentService studentService;
    private final StudentExamRepository studentExamRepository;

    @Override
    public StudentExam getStudentExam(Integer studentId, Integer examId) {
        Student student = studentService.getStudent(studentId);
        Exam exam = examService.getExam(examId);
        StudentExamPK studentExamPK = new StudentExamPK(student, exam);
        return studentExamRepository.findById(studentExamPK).orElseThrow(() -> new NotFoundException("StudentExam with this id not found"));
    }

    @Override
    public List<StudentExam> getExamOfStudent(Integer studentId) {
        List<StudentExam> exams = studentExamRepository.findByPkStudent(studentService.getStudent(studentId));
        return exams;
    }

    @Override
    public List<StudentExam> getStudentOfExam(Integer examId) {
        List<StudentExam> exam = studentExamRepository.findByPkExam(examService.getExam(examId));
        return exam;
    }

    @Override
    public StudentExam createStudentExam(StudentExam studentExam) {
        return updateStudentExam(studentExam);
    }

    @Override
    public StudentExam updateStudentExam(StudentExam studentExam) {
        return studentExamRepository.saveAndFlush(studentExam);
    }

    @Override
    public void deleteStudentExam(Integer studentId, Integer examId) {
        Student student = studentService.getStudent(studentId);
        Exam exam = examService.getExam(examId);
        StudentExamPK studentExamPK = new StudentExamPK(student, exam);
        studentExamRepository.deleteById(studentExamPK);
    }


}
