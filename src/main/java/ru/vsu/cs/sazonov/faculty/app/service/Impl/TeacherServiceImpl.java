package ru.vsu.cs.sazonov.faculty.app.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.vsu.cs.sazonov.faculty.app.exception.NotFoundException;
import ru.vsu.cs.sazonov.faculty.app.service.TeacherService;
import ru.vsu.cs.sazonov.faculty.item.TeacherRepository;
import ru.vsu.cs.sazonov.faculty.item.model.Teacher;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    @Override
    public List<Teacher> getAllTeacher(PageRequest pageRequest) {
        return teacherRepository.findAll(pageRequest).getContent();
    }

    @Override
    public Teacher getTeacher(Integer teacherId) {
        return teacherRepository.findById(teacherId).orElseThrow(() -> new NotFoundException("Book with this id not found"));
    }

    @Override
    public Teacher createTeacher(Teacher teacher) {
        return updateTeacher(teacher);
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        return teacherRepository.saveAndFlush(teacher);
    }

    @Override
    public void deleteTeacher(Integer teacherId) {
        teacherRepository.deleteById(teacherId);
    }
}
