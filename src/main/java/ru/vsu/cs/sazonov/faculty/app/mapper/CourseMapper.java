package ru.vsu.cs.sazonov.faculty.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.vsu.cs.sazonov.faculty.api.model.CourseDto;
import ru.vsu.cs.sazonov.faculty.item.model.Course;

import java.util.List;

@Mapper
public interface CourseMapper {
    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);
    CourseDto toDto(Course item);

    List<CourseDto> toDto(List<Course> items);

}
