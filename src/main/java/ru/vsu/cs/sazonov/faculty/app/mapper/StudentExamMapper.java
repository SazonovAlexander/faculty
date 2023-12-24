package ru.vsu.cs.sazonov.faculty.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.vsu.cs.sazonov.faculty.api.model.ScheduleDto;
import ru.vsu.cs.sazonov.faculty.api.model.StudentExamDto;
import ru.vsu.cs.sazonov.faculty.item.model.Schedule;
import ru.vsu.cs.sazonov.faculty.item.model.StudentExam;

import java.util.List;

@Mapper
public interface StudentExamMapper {
    StudentExamMapper INSTANCE = Mappers.getMapper(StudentExamMapper.class);
    StudentExamDto toDto(StudentExam item);

    List<StudentExamDto> toDto(List<StudentExam> items);

    StudentExam mapToItem(StudentExamDto dto);
}
