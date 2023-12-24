package ru.vsu.cs.sazonov.faculty.app.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.sazonov.faculty.api.StudentExamApi;
import ru.vsu.cs.sazonov.faculty.api.model.StudentExamDto;
import ru.vsu.cs.sazonov.faculty.app.mapper.StudentExamMapper;
import ru.vsu.cs.sazonov.faculty.app.service.StudentExamService;
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

    @Override
    public ResponseEntity<List<StudentExamDto>> getStudentOfExam(Integer examId) {
        List<StudentExam> examOfStudent = studentExamService.getStudentOfExam(examId);
        List<StudentExamDto> dtos = StudentExamMapper.INSTANCE.toDto(examOfStudent);
        return ResponseEntity.ok(dtos);
    }

    @Override
    public ResponseEntity<StudentExamDto> createStudentExam(StudentExamDto studentExam) {
        StudentExam studentExamItem = StudentExamMapper.INSTANCE.mapToItem(studentExam);
        StudentExam createdStudentExam = studentExamService.createStudentExam(studentExamItem);
        StudentExamDto studentExamDto = StudentExamMapper.INSTANCE.toDto(createdStudentExam);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentExamDto);
    }

    @Override
    public ResponseEntity<StudentExamDto> updateStudentExam(Integer studentId, Integer examId, StudentExamDto studentExam) {


        StudentExam currentStudentExam = studentExamService.getStudentExam(studentId, examId);
        StudentExam newStudentExam = StudentExamMapper.INSTANCE.mapToItem(studentExam);
        currentStudentExam.setGrade(newStudentExam.getGrade());


        StudentExam updatedStudentExam = studentExamService.updateStudentExam(currentStudentExam);
        return ResponseEntity.ok(StudentExamMapper.INSTANCE.toDto(updatedStudentExam));
    }

    @Override
    public ResponseEntity<StudentExamDto> deleteStudentExam(Integer studentId, Integer examId) {
        studentExamService.deleteStudentExam(studentId, examId);
        return ResponseEntity.ok().build();
    }

}
