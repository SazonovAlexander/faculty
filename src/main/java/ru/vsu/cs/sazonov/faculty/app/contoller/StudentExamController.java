package ru.vsu.cs.sazonov.faculty.app.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.sazonov.faculty.api.StudentExamApi;
import ru.vsu.cs.sazonov.faculty.api.model.StudentDto;
import ru.vsu.cs.sazonov.faculty.api.model.StudentExamDto;
import ru.vsu.cs.sazonov.faculty.app.mapper.StudentExamMapper;
import ru.vsu.cs.sazonov.faculty.app.mapper.StudentMapper;
import ru.vsu.cs.sazonov.faculty.app.service.StudentExamService;
import ru.vsu.cs.sazonov.faculty.item.StudentExamRepository;
import ru.vsu.cs.sazonov.faculty.item.model.StudentExam;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class StudentExamController implements StudentExamApi {

    private final StudentExamService studentExamService;

    @Override
    public ResponseEntity<List<StudentExamDto>> getExamOfStudent(Integer studentId) {
        List<StudentExam> examOfStudent = studentExamService.getExamOfStudent(studentId);
        List<StudentExamDto> dtos = StudentExamMapper.INSTANCE.toDto(examOfStudent);
        return ResponseEntity.ok(dtos);
    }

}
