package ru.vsu.cs.sazonov.faculty.app.service;

import ru.vsu.cs.sazonov.faculty.item.model.Party;
import ru.vsu.cs.sazonov.faculty.item.model.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> getAllTeacher();

    Teacher getTeacher(Integer teacherId);

    Teacher createTeacher(Teacher teacher);

    Teacher updateTeacher(Teacher teacher);

    void deleteTeacher(Integer teacherId);

}
