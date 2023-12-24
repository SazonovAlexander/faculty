package ru.vsu.cs.sazonov.faculty.app.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.vsu.cs.sazonov.faculty.app.exception.NotFoundException;
import ru.vsu.cs.sazonov.faculty.app.service.DictionaryService;
import ru.vsu.cs.sazonov.faculty.app.service.PartyService;
import ru.vsu.cs.sazonov.faculty.app.service.ScheduleService;
import ru.vsu.cs.sazonov.faculty.app.service.TeacherService;
import ru.vsu.cs.sazonov.faculty.item.ScheduleRepository;
import ru.vsu.cs.sazonov.faculty.item.model.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final DictionaryService dictionaryService;
    private final TeacherService teacherService;
    private final PartyService partyService;

    @Override
    public Schedule getSchedule(Integer classroomId, Integer partyId, Integer teacherId, Integer courseId) {
        Classroom classroom = dictionaryService.getClassroom(classroomId);
        Course course = dictionaryService.getCourse(courseId);
        Party party = partyService.getParty(partyId);
        Teacher teacher = teacherService.getTeacher(teacherId);
        SchedulePK schedulePK = new SchedulePK(party, course, classroom, teacher);
        return scheduleRepository.findById(schedulePK).orElseThrow(() -> new NotFoundException("Schedule with this id not found"));
    }

    @Override
    public List<Schedule> getAllSchedule(PageRequest pageRequest) {
        return scheduleRepository.findAll(pageRequest).getContent();
    }

    @Override
    public List<Schedule> getByClassroom(Integer classroomId) {
        Classroom classroom = dictionaryService.getClassroom(classroomId);
        return scheduleRepository.findByPkClassroom(classroom);
    }

    @Override
    public List<Schedule> getByParty(Integer partyId) {
        Party party = partyService.getParty(partyId);
        return scheduleRepository.findByPkParty(party);
    }

    @Override
    public List<Schedule> getByTeacher(Integer teacherId) {
        Teacher teacher = teacherService.getTeacher(teacherId);
        return scheduleRepository.findByPkTeacher(teacher);
    }

    @Override
    public List<Schedule> getByCourse(Integer courseId) {
        Course course = dictionaryService.getCourse(courseId);
        return scheduleRepository.findByPkCourse(course);
    }

    @Override
    public Schedule createSchedule(Schedule schedule) {
        return updateSchedule(schedule);
    }

    @Override
    public Schedule updateSchedule(Schedule schedule) {
        return scheduleRepository.saveAndFlush(schedule);
    }

    @Override
    public void deleteSchedule(Integer classroomId, Integer partyId, Integer teacherId, Integer courseId) {
        Classroom classroom = dictionaryService.getClassroom(classroomId);
        Course course = dictionaryService.getCourse(courseId);
        Party party = partyService.getParty(partyId);
        Teacher teacher = teacherService.getTeacher(teacherId);
        SchedulePK schedulePK = new SchedulePK(party, course, classroom, teacher);
        scheduleRepository.deleteById(schedulePK);
    }
}
