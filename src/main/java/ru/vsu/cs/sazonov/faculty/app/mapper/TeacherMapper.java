package ru.vsu.cs.sazonov.faculty.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.vsu.cs.sazonov.faculty.api.model.PartyDto;
import ru.vsu.cs.sazonov.faculty.api.model.ScheduleDto;
import ru.vsu.cs.sazonov.faculty.api.model.TeacherDto;
import ru.vsu.cs.sazonov.faculty.item.model.Party;
import ru.vsu.cs.sazonov.faculty.item.model.Schedule;
import ru.vsu.cs.sazonov.faculty.item.model.Teacher;

import java.util.List;

@Mapper
public interface TeacherMapper {
    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);
    TeacherDto toDto(Teacher item);

    List<TeacherDto> toDto(List<Teacher> items);

    Teacher mapToItem(TeacherDto dto);
}
