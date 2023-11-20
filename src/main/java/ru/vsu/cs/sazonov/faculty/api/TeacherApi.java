package ru.vsu.cs.sazonov.faculty.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.sazonov.faculty.api.model.PartyDto;
import ru.vsu.cs.sazonov.faculty.api.model.TeacherDto;

import java.util.List;

public interface TeacherApi {

    @GetMapping("/teacher")
    ResponseEntity<List<TeacherDto>> getAllTeacher();

    @GetMapping("/teacher/{teacherId}")
    ResponseEntity<TeacherDto> getTeacher(
            @PathVariable("teacherId")
            Integer teacherId
    );

    @PostMapping("/teacher")
    ResponseEntity<TeacherDto> createTeacher(
            @RequestBody
            TeacherDto teacher
    );

    @PutMapping("/teacher/{teacherId}")
    ResponseEntity<TeacherDto> updateTeacher(
            @PathVariable("teacherId")
            Integer teacherId,

            @RequestBody
            TeacherDto teacher
    );

    @DeleteMapping("/teacher/{teacherId}")
    ResponseEntity<TeacherDto> deleteTeacher(
            @PathVariable("teacherId")
            Integer teacherId
    );

}
