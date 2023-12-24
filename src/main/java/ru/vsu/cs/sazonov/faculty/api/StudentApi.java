package ru.vsu.cs.sazonov.faculty.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.sazonov.faculty.api.model.StudentDto;
import ru.vsu.cs.sazonov.faculty.api.model.StudentExamDto;

import java.util.List;

public interface StudentApi {

    @GetMapping("/student")
    ResponseEntity<List<StudentDto>> getAllStudent(
        @RequestParam(required = false, defaultValue = "0") int page,
        @RequestParam(required = false, defaultValue = "10") int size,
        @RequestParam(required = false, defaultValue = "id") String sortParam

    );

    @GetMapping("/student/find")
    ResponseEntity<List<StudentDto>> getStudentsWithFilter(
            @RequestParam(required = false) String fullName,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    );

    @GetMapping("/student/{studentId}")
    ResponseEntity<StudentDto> getStudent(
            @PathVariable("studentId")
            Integer studentId
    );

    @PostMapping("/student")
    ResponseEntity<StudentDto> createStudent(
            @RequestBody
            StudentDto student
    );

    @PutMapping("/student/{studentId}")
    ResponseEntity<StudentDto> updateStudent(
            @PathVariable("studentId")
            Integer studentId,

            @RequestBody
            StudentDto student
    );

    @DeleteMapping("/student/{studentId}")
    ResponseEntity<StudentDto> deleteStudent(
            @PathVariable("studentId")
            Integer studentId
    );


}

