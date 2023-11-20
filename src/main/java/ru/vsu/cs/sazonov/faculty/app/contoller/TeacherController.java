package ru.vsu.cs.sazonov.faculty.app.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.sazonov.faculty.api.TeacherApi;
import ru.vsu.cs.sazonov.faculty.api.model.PartyDto;
import ru.vsu.cs.sazonov.faculty.api.model.TeacherDto;
import ru.vsu.cs.sazonov.faculty.app.mapper.PartyMapper;
import ru.vsu.cs.sazonov.faculty.app.mapper.TeacherMapper;
import ru.vsu.cs.sazonov.faculty.app.service.TeacherService;
import ru.vsu.cs.sazonov.faculty.item.model.Party;
import ru.vsu.cs.sazonov.faculty.item.model.Teacher;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TeacherController implements TeacherApi {

    private final TeacherService teacherService;
    @Override
    public ResponseEntity<List<TeacherDto>> getAllTeacher() {
        List<Teacher> teachers = teacherService.getAllTeacher();
        List<TeacherDto> teacherDtos = TeacherMapper.INSTANCE.toDto(teachers);
        return ResponseEntity.ok(teacherDtos);
    }

    @Override
    public ResponseEntity<TeacherDto> getTeacher(Integer teacherId) {
        Teacher teacher = teacherService.getTeacher(teacherId);
        TeacherDto teacherDto = TeacherMapper.INSTANCE.toDto(teacher);
        return ResponseEntity.ok(teacherDto);
    }

    @Override
    public ResponseEntity<TeacherDto> createTeacher(TeacherDto teacher) {
        Teacher teacherItem = TeacherMapper.INSTANCE.mapToItem(teacher);
        Teacher createdTeacher = teacherService.createTeacher(teacherItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(TeacherMapper.INSTANCE.toDto(createdTeacher));
    }

    @Override
    public ResponseEntity<TeacherDto> updateTeacher(Integer teacherId, TeacherDto teacher) {
        Teacher currentTeacher = teacherService.getTeacher(teacherId);
        Teacher newTeacher = TeacherMapper.INSTANCE.mapToItem(teacher);
        currentTeacher.setFullName(newTeacher.getFullName());
        currentTeacher.setDegree(newTeacher.getDegree());
        currentTeacher.setEmail(newTeacher.getEmail());

        Teacher updatedTeacher = teacherService.updateTeacher(currentTeacher);
        return ResponseEntity.ok(TeacherMapper.INSTANCE.toDto(updatedTeacher));
    }

    @Override
    public ResponseEntity<TeacherDto> deleteTeacher(Integer teacherId) {
        teacherService.deleteTeacher(teacherId);
        return ResponseEntity.ok().build();
    }
}
