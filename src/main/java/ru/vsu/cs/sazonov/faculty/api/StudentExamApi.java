package ru.vsu.cs.sazonov.faculty.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.sazonov.faculty.api.model.StudentDto;
import ru.vsu.cs.sazonov.faculty.api.model.StudentExamDto;
import ru.vsu.cs.sazonov.faculty.api.model.StudentExamPKDto;
import ru.vsu.cs.sazonov.faculty.item.model.StudentExam;
import ru.vsu.cs.sazonov.faculty.item.model.StudentExamPK;

import java.util.List;

public interface StudentExamApi {

    @GetMapping("/student/exam/{studentId}")
    ResponseEntity<List<StudentExamDto>> getExamOfStudent(
            @PathVariable Integer studentId
    );

    @GetMapping("/exam/student/{examId}")
    ResponseEntity<List<StudentExamDto>> getStudentOfExam(
            @PathVariable Integer examId
    );

    @PostMapping("/exam/student")
    ResponseEntity<StudentExamDto> createStudentExam(
            @RequestBody
            StudentExamDto studentExam
    );

    @PutMapping("exam/student/{studentId}/{examId}")
    ResponseEntity<StudentExamDto> updateStudentExam(
            @PathVariable("studentId")
            Integer studentId,

            @PathVariable("examId")
            Integer examId,

            @RequestBody
            StudentExamDto studentExam
    );

    @DeleteMapping("exam/student/{studentId}/{examId}")
    ResponseEntity<StudentExamDto> deleteStudentExam(
            @PathVariable("studentId")
            Integer studentId,

            @PathVariable("examId")
            Integer examId
    );
}
