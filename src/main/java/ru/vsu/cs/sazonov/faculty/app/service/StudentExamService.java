package ru.vsu.cs.sazonov.faculty.app.service;

import ru.vsu.cs.sazonov.faculty.item.model.StudentExam;

import java.util.List;

public interface StudentExamService {


    List<StudentExam> getExamOfStudent(Integer studentId);

}
