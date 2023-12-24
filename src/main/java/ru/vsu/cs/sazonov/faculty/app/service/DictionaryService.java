package ru.vsu.cs.sazonov.faculty.app.service;

import ru.vsu.cs.sazonov.faculty.item.model.Classroom;
import ru.vsu.cs.sazonov.faculty.item.model.Course;

import java.util.List;

public interface DictionaryService {

    List<Course> getAllCourse();

    List<Classroom> getAllClassroom();

    Classroom getClassroom(Integer classroomId);

    Course getCourse(Integer courseId);

}
