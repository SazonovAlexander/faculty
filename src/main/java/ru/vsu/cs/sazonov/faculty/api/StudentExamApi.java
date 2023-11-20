package ru.vsu.cs.sazonov.faculty.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.vsu.cs.sazonov.faculty.api.model.StudentDto;
import ru.vsu.cs.sazonov.faculty.api.model.StudentExamDto;
import ru.vsu.cs.sazonov.faculty.item.model.StudentExam;

import java.util.List;

public interface StudentExamApi {

    @GetMapping("/student/exam/{studentId}")
    ResponseEntity<List<StudentExamDto>> getExamOfStudent(
            @PathVariable Integer studentId
    );
}
