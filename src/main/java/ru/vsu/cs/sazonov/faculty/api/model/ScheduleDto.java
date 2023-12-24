package ru.vsu.cs.sazonov.faculty.api.model;

import lombok.*;
import ru.vsu.cs.sazonov.faculty.item.model.Classroom;
import ru.vsu.cs.sazonov.faculty.item.model.Course;
import ru.vsu.cs.sazonov.faculty.item.model.Party;
import ru.vsu.cs.sazonov.faculty.item.model.Teacher;

@Getter
@Setter
@AllArgsConstructor
@Data
@Builder
public class ScheduleDto {

    private SchedulePKDto pk;
    private String day;
    private String time;

}
