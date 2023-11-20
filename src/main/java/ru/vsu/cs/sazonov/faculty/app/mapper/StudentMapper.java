package ru.vsu.cs.sazonov.faculty.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.vsu.cs.sazonov.faculty.api.model.ScheduleDto;
import ru.vsu.cs.sazonov.faculty.api.model.StudentDto;
import ru.vsu.cs.sazonov.faculty.api.model.TeacherDto;
import ru.vsu.cs.sazonov.faculty.item.model.Schedule;
import ru.vsu.cs.sazonov.faculty.item.model.Student;
import ru.vsu.cs.sazonov.faculty.item.model.Teacher;

import java.util.List;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);
    StudentDto toDto(Student item);
    List<StudentDto> toDto(List<Student> items);

    Student mapToItem(StudentDto dto);

    List<Student> mapToItem(List<StudentDto> dtos);
}
