package ru.vsu.cs.sazonov.faculty.app.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.sazonov.faculty.api.ScheduleApi;
import ru.vsu.cs.sazonov.faculty.api.model.ScheduleDto;
import ru.vsu.cs.sazonov.faculty.api.model.StudentExamDto;
import ru.vsu.cs.sazonov.faculty.app.mapper.ScheduleMapper;
import ru.vsu.cs.sazonov.faculty.app.mapper.StudentExamMapper;
import ru.vsu.cs.sazonov.faculty.app.service.ScheduleService;
import ru.vsu.cs.sazonov.faculty.item.model.Schedule;
import ru.vsu.cs.sazonov.faculty.item.model.StudentExam;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ScheduleController implements ScheduleApi {

    private final ScheduleService scheduleService;
    private final ru.vsu.cs.sazonov.faculty.app.mapper.test.ScheduleMapper scheduleMapper;

    @Override
    public ResponseEntity<List<ScheduleDto>> getAllSchedule() {
        List<Schedule> allSchedule = scheduleService.getAllSchedule();
        List<ScheduleDto> dto = scheduleMapper.mapScheduleToDto(allSchedule);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<List<ScheduleDto>> getScheduleOfClassroom(Integer classroomId) {
        List<Schedule> byClassroom = scheduleService.getByClassroom(classroomId);
        List<ScheduleDto> dto = ScheduleMapper.INSTANCE.toDto(byClassroom);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<List<ScheduleDto>> getScheduleOfParty(Integer partyId) {
        List<Schedule> byParty = scheduleService.getByParty(partyId);
        List<ScheduleDto> dto = ScheduleMapper.INSTANCE.toDto(byParty);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<List<ScheduleDto>> getScheduleOfTeacher(Integer teacherId) {
        List<Schedule> byTeacher = scheduleService.getByTeacher(teacherId);
        List<ScheduleDto> dto = ScheduleMapper.INSTANCE.toDto(byTeacher);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<List<ScheduleDto>> getScheduleOfCourse(Integer courseId) {
        List<Schedule> byCourse = scheduleService.getByCourse(courseId);
        List<ScheduleDto> dto = ScheduleMapper.INSTANCE.toDto(byCourse);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<ScheduleDto> createSchedule(ScheduleDto schedule) {
        Schedule scheduleItem = scheduleMapper.mapDtoToSchedule(schedule);
        Schedule createdSchedule = scheduleService.createSchedule(scheduleItem);
        ScheduleDto dto = ScheduleMapper.INSTANCE.toDto(createdSchedule);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @Override
    public ResponseEntity<ScheduleDto> updateSchedule(Integer classroomId, Integer partyId, Integer teacherId, Integer courseId, ScheduleDto schedule) {
        Schedule currentSchedule = scheduleService.getSchedule(classroomId, partyId, teacherId, courseId);
        Schedule newSchedule = ScheduleMapper.INSTANCE.mapToItem(schedule);
        currentSchedule.setDay(newSchedule.getDay());
        currentSchedule.setTime(newSchedule.getTime());

        Schedule updateSchedule = scheduleService.updateSchedule(currentSchedule);
        return ResponseEntity.ok(ScheduleMapper.INSTANCE.toDto(updateSchedule));
    }

    @Override
    public ResponseEntity<ScheduleDto> deleteSchedule(Integer classroomId, Integer partyId, Integer teacherId, Integer courseId) {
        scheduleService.deleteSchedule(classroomId, partyId, teacherId, courseId);
        return ResponseEntity.ok().build();
    }
}
