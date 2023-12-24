package ru.vsu.cs.sazonov.faculty.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.sazonov.faculty.api.model.ExamDto;

import java.util.List;

public interface ExamApi {

    @GetMapping("/exam")
    ResponseEntity<List<ExamDto>> getAllExam(
        @RequestParam(required = false, defaultValue = "0") int page,
        @RequestParam(required = false, defaultValue = "10") int size
    );

    @GetMapping("/exam/{examId}")
    ResponseEntity<ExamDto> getExam(
            @PathVariable("examId")
            Integer examId
    );

    @PostMapping("/exam")
    ResponseEntity<ExamDto> createExam(
            @RequestBody
            ExamDto exam
    );

    @PutMapping("/exam/{examId}")
    ResponseEntity<ExamDto> updateExam(
            @PathVariable("examId")
            Integer examId,

            @RequestBody
            ExamDto exam
    );

    @DeleteMapping("/exam/{examId}")
    ResponseEntity<ExamDto> deleteExam(
            @PathVariable("examId")
            Integer examId
    );

}
