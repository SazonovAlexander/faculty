package ru.vsu.cs.sazonov.faculty.app.service;

import ru.vsu.cs.sazonov.faculty.item.model.Exam;

import java.util.List;

public interface ExamService {

    List<Exam> getAllExam();

    Exam getExam(Integer examId);

    Exam createExam(Exam exam);

    Exam updateExam(Exam exam);

    void deleteExam(Integer examId);

}
