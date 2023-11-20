package ru.vsu.cs.sazonov.faculty.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.vsu.cs.sazonov.faculty.api.model.ExamDto;
import ru.vsu.cs.sazonov.faculty.item.model.Course;
import ru.vsu.cs.sazonov.faculty.item.model.Exam;

import java.util.List;
@Mapper
public interface ExamMapper {

    ExamMapper INSTANCE = Mappers.getMapper(ExamMapper.class);

    ExamDto toDto(Exam item);
    List<ExamDto> toDto(List<Exam> items);

    Exam mapToItem(ExamDto examDto);

}
