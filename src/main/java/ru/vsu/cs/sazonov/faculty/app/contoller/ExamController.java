package ru.vsu.cs.sazonov.faculty.app.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.sazonov.faculty.api.ExamApi;
import ru.vsu.cs.sazonov.faculty.api.model.ExamDto;
import ru.vsu.cs.sazonov.faculty.app.mapper.ExamMapper;
import ru.vsu.cs.sazonov.faculty.app.mapper.PartyMapper;
import ru.vsu.cs.sazonov.faculty.app.service.ExamService;
import ru.vsu.cs.sazonov.faculty.item.model.Exam;
import ru.vsu.cs.sazonov.faculty.item.model.Party;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ExamController implements ExamApi {

    private final ExamService examService;

    @Override
    public ResponseEntity<List<ExamDto>> getAllExam() {
        List<Exam> exam = examService.getAllExam();
        List<ExamDto> examDtos = ExamMapper.INSTANCE.toDto(exam);
        return ResponseEntity.ok(examDtos);
    }

    @Override
    public ResponseEntity<ExamDto> getExam(Integer examId) {
        Exam exam = examService.getExam(examId);
        ExamDto dto = ExamMapper.INSTANCE.toDto(exam);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<ExamDto> createExam(ExamDto exam) {
        Exam examItem = ExamMapper.INSTANCE.mapToItem(exam);
        Exam createdExam = examService.createExam(examItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(ExamMapper.INSTANCE.toDto(createdExam));
    }

    @Override
    public ResponseEntity<ExamDto> updateExam(Integer examId, ExamDto exam) {

        Exam currentExam = examService.getExam(examId);
        Exam newExam = ExamMapper.INSTANCE.mapToItem(exam);
        currentExam.setParty(newExam.getParty());
        currentExam.setDate(newExam.getDate());
        currentExam.setClassroom(newExam.getClassroom());
        currentExam.setCourse(newExam.getCourse());

        Exam updatedExam = examService.updateExam(currentExam);
        return ResponseEntity.ok(ExamMapper.INSTANCE.toDto(updatedExam));

    }

    @Override
    public ResponseEntity<ExamDto> deleteExam(Integer examId) {
        examService.deleteExam(examId);
        return ResponseEntity.ok().build();
    }
}
