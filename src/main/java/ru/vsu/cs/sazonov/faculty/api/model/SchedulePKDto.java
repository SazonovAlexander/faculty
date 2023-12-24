package ru.vsu.cs.sazonov.faculty.api.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Data
@Builder
public class SchedulePKDto {

    private PartyDto party;
    private CourseDto course;
    private ClassroomDto classroom;
    private TeacherDto teacher;

}
