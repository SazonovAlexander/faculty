package ru.vsu.cs.sazonov.faculty.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import ru.vsu.cs.sazonov.faculty.api.model.ClassroomDto;
import ru.vsu.cs.sazonov.faculty.api.model.CourseDto;

import java.util.List;

public interface DictionaryApi {

    @GetMapping("/classrooms")
    ResponseEntity<List<ClassroomDto>> getAllClassroom();

    @GetMapping("/courses")
    ResponseEntity<List<CourseDto>> getAllCourse();

}
