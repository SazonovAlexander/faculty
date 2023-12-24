package ru.vsu.cs.sazonov.faculty.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.sazonov.faculty.api.model.ScheduleDto;
import ru.vsu.cs.sazonov.faculty.item.model.Schedule;

import java.util.List;

public interface ScheduleApi {

    @GetMapping("schedule")
    ResponseEntity<List<ScheduleDto>> getAllSchedule();

    @GetMapping("schedule/classroom/{classroomId}")
    ResponseEntity<List<ScheduleDto>> getScheduleOfClassroom(
            @PathVariable
            Integer classroomId
    );

    @GetMapping("schedule/party/{partyId}")
    ResponseEntity<List<ScheduleDto>> getScheduleOfParty(
            @PathVariable
            Integer partyId
    );

    @GetMapping("schedule/teacher/{teacherId}")
    ResponseEntity<List<ScheduleDto>> getScheduleOfTeacher(
            @PathVariable
            Integer teacherId
    );


    @GetMapping("schedule/course/{courseId}")
    ResponseEntity<List<ScheduleDto>> getScheduleOfCourse(
            @PathVariable
            Integer courseId
    );

    @PostMapping("schedule")
    ResponseEntity<ScheduleDto> createSchedule(
            @RequestBody
            ScheduleDto schedule
    );


    @PutMapping("schedule/{classroomId}/{partyId}/{teacherId}/{courseId}")
    ResponseEntity<ScheduleDto> updateSchedule(
            @PathVariable
            Integer classroomId,

            @PathVariable
            Integer partyId,

            @PathVariable
            Integer teacherId,

            @PathVariable
            Integer courseId,

            @RequestBody
            ScheduleDto schedule
    );

    @DeleteMapping("schedule/{classroomId}/{partyId}/{teacherId}/{courseId}")
    ResponseEntity<ScheduleDto> deleteSchedule(
            @PathVariable
            Integer classroomId,

            @PathVariable
            Integer partyId,

            @PathVariable
            Integer teacherId,

            @PathVariable
            Integer courseId
    );

}
