package ru.vsu.cs.sazonov.faculty.api.model;

import lombok.*;


import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Data
@Builder
public class ExamDto {

    private Integer id;
    private String date;
    private PartyDto party;
    private CourseDto course;
    private ClassroomDto classroom;

}
