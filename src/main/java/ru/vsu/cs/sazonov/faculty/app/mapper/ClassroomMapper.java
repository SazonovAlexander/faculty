package ru.vsu.cs.sazonov.faculty.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.vsu.cs.sazonov.faculty.api.model.ClassroomDto;
import ru.vsu.cs.sazonov.faculty.item.model.Classroom;

import java.util.List;

@Mapper
public interface ClassroomMapper {
    ClassroomMapper INSTANCE = Mappers.getMapper(ClassroomMapper.class);
    ClassroomDto toDto(Classroom item);

    List<ClassroomDto> toDto(List<Classroom> items);

}
