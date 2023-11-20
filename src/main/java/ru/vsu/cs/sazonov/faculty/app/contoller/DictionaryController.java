package ru.vsu.cs.sazonov.faculty.app.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.sazonov.faculty.api.DictionaryApi;
import ru.vsu.cs.sazonov.faculty.api.model.ClassroomDto;
import ru.vsu.cs.sazonov.faculty.api.model.CourseDto;
import ru.vsu.cs.sazonov.faculty.app.mapper.ClassroomMapper;
import ru.vsu.cs.sazonov.faculty.app.mapper.CourseMapper;
import ru.vsu.cs.sazonov.faculty.app.service.DictionaryService;
import ru.vsu.cs.sazonov.faculty.item.model.Classroom;
import ru.vsu.cs.sazonov.faculty.item.model.Course;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DictionaryController implements DictionaryApi {

    private final DictionaryService dictionaryService;
    @Override
    public ResponseEntity<List<ClassroomDto>> getAllClassroom() {
        List<Classroom> allClassroom = dictionaryService.getAllClassroom();
        List<ClassroomDto> classroomDtos = ClassroomMapper.INSTANCE.toDto(allClassroom);
        return ResponseEntity.ok(classroomDtos);
    }

    @Override
    public ResponseEntity<List<CourseDto>> getAllCourse() {
        List<Course> allCourse = dictionaryService.getAllCourse();
        List<CourseDto> courseDtos = CourseMapper.INSTANCE.toDto(allCourse);
        return ResponseEntity.ok(courseDtos);
    }

}
