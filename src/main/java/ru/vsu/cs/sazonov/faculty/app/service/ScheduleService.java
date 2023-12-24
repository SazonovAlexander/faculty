package ru.vsu.cs.sazonov.faculty.app.service;

import org.springframework.data.domain.PageRequest;
import ru.vsu.cs.sazonov.faculty.item.model.*;

import java.util.List;

public interface ScheduleService {

    Schedule getSchedule(Integer classroomId, Integer partyId, Integer teacherId, Integer courseId);

    List<Schedule> getAllSchedule (PageRequest pageRequest);
    List<Schedule> getByClassroom (Integer classroomId);
    List<Schedule> getByParty (Integer partyId);

    List<Schedule> getByTeacher (Integer teacherId);

    List<Schedule> getByCourse (Integer courseId);

    Schedule createSchedule (Schedule schedule);

    Schedule updateSchedule (Schedule schedule);

    void deleteSchedule(Integer classroomId, Integer partyId, Integer teacherId, Integer courseId);

}
