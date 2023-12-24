package ru.vsu.cs.sazonov.faculty.app.mapper.test;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import ru.vsu.cs.sazonov.faculty.api.model.ScheduleDto;
import ru.vsu.cs.sazonov.faculty.api.model.SchedulePKDto;
import ru.vsu.cs.sazonov.faculty.app.service.DictionaryService;
import ru.vsu.cs.sazonov.faculty.app.service.PartyService;
import ru.vsu.cs.sazonov.faculty.app.service.TeacherService;
import ru.vsu.cs.sazonov.faculty.item.model.Schedule;
import ru.vsu.cs.sazonov.faculty.item.model.SchedulePK;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")

public abstract class ScheduleMapper {

    @Autowired
    protected PartyService partyService;
    @Autowired
    protected DictionaryService dictionaryService;
    @Autowired
    protected TeacherService teacherService;

    public abstract SchedulePK mapDtoToItem(SchedulePKDto schedulePKDto);
    public abstract SchedulePKDto mapItemToDto(SchedulePK schedulePK);

    public Schedule mapDtoToSchedule(ScheduleDto scheduleDto) {
        SchedulePK schedulePK = mapDtoToItem(SchedulePKDto.builder()
                        .party(scheduleDto.getParty())
                        .classroom(scheduleDto.getClassroom())
                        .course(scheduleDto.getCourse())
                        .teacher(scheduleDto.getTeacher()).build());
        return Schedule.builder().pk(schedulePK).day(scheduleDto.getDay()).time(scheduleDto.getTime()).build();
    };

    public ScheduleDto mapScheduleToDto(Schedule schedule) {
        SchedulePKDto schedulePKDto = mapItemToDto(schedule.getPk());
        return ScheduleDto.builder()
                .party(schedulePKDto.getParty())
                .classroom(schedulePKDto.getClassroom())
                .teacher(schedulePKDto.getTeacher())
                .course(schedulePKDto.getCourse())
                .day(schedule.getDay())
                .time(schedule.getTime()).build();
    }

    public List<ScheduleDto> mapScheduleToDto(List<Schedule> scheduleList) {
        return scheduleList.stream()
                .map(this::mapScheduleToDto)
                .collect(Collectors.toList());
    }

}
