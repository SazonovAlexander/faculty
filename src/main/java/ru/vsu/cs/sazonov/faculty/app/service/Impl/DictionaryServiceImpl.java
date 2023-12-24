package ru.vsu.cs.sazonov.faculty.app.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vsu.cs.sazonov.faculty.app.exception.NotFoundException;
import ru.vsu.cs.sazonov.faculty.app.service.DictionaryService;
import ru.vsu.cs.sazonov.faculty.item.ClassroomRepository;
import ru.vsu.cs.sazonov.faculty.item.CourseRepository;
import ru.vsu.cs.sazonov.faculty.item.model.Classroom;
import ru.vsu.cs.sazonov.faculty.item.model.Course;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DictionaryServiceImpl implements DictionaryService {

    private final CourseRepository courseRepository;
    private final ClassroomRepository classroomRepository;
    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public List<Classroom> getAllClassroom() {
        return classroomRepository.findAll();
    }

    @Override
    public Classroom getClassroom(Integer classroomId) {
        return classroomRepository.findById(classroomId).orElseThrow(() -> new NotFoundException("Classroom with this id not found"));
    }

    @Override
    public Course getCourse(Integer courseId) {
        return courseRepository.findById(courseId).orElseThrow(() -> new NotFoundException("Course with this id not found"));
    }
}
