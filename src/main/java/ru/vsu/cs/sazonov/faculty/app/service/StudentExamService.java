package ru.vsu.cs.sazonov.faculty.app.service;

import ru.vsu.cs.sazonov.faculty.item.model.Party;
import ru.vsu.cs.sazonov.faculty.item.model.StudentExam;

import java.util.List;

public interface StudentExamService {

    StudentExam getStudentExam(Integer studentId, Integer examId);
    List<StudentExam> getExamOfStudent(Integer studentId);

    List<StudentExam> getStudentOfExam(Integer examId);

    StudentExam createStudentExam(StudentExam studentExam);

    StudentExam updateStudentExam(StudentExam studentExam);

    void deleteStudentExam(Integer studentId, Integer examId);

}
