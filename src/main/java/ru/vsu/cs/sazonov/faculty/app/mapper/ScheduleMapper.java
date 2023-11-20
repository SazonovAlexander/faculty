package ru.vsu.cs.sazonov.faculty.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.vsu.cs.sazonov.faculty.api.model.ExamDto;
import ru.vsu.cs.sazonov.faculty.api.model.ScheduleDto;
import ru.vsu.cs.sazonov.faculty.item.model.Exam;
import ru.vsu.cs.sazonov.faculty.item.model.Schedule;

import java.util.List;

@Mapper
public interface ScheduleMapper {
    ScheduleMapper INSTANCE = Mappers.getMapper(ScheduleMapper.class);
    ScheduleDto toDto(Schedule item);

    List<ScheduleDto> toDto(List<Schedule> items);
}
