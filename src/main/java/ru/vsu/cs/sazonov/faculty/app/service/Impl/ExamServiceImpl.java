package ru.vsu.cs.sazonov.faculty.app.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.vsu.cs.sazonov.faculty.app.exception.NotFoundException;
import ru.vsu.cs.sazonov.faculty.app.service.ExamService;
import ru.vsu.cs.sazonov.faculty.item.ExamRepository;
import ru.vsu.cs.sazonov.faculty.item.model.Exam;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamServiceImpl implements ExamService {

    private final ExamRepository examRepository;


    @Override
    public List<Exam> getAllExam(PageRequest pageRequest) {
        return examRepository.findAll(pageRequest).getContent();
    }

    @Override
    public Exam getExam(Integer examId) {
        return examRepository.findById(examId).orElseThrow(() -> new NotFoundException("Exam with this id not found"));
    }

    @Override
    public Exam createExam(Exam exam) {
        return updateExam(exam);
    }

    @Override
    public Exam updateExam(Exam exam) {
        return examRepository.saveAndFlush(exam);
    }

    @Override
    public void deleteExam(Integer examId) {
        examRepository.deleteById(examId);
    }
}
