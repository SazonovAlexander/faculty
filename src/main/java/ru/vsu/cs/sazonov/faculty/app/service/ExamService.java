package ru.vsu.cs.sazonov.faculty.app.service;

import org.springframework.data.domain.PageRequest;
import ru.vsu.cs.sazonov.faculty.item.model.Exam;

import java.util.List;

public interface ExamService {

    List<Exam> getAllExam(PageRequest pageRequest);

    Exam getExam(Integer examId);

    Exam createExam(Exam exam);

    Exam updateExam(Exam exam);

    void deleteExam(Integer examId);

}
