package ru.vsu.cs.sazonov.faculty.api.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Data
@Builder
public class StudentExamDto {

    private Integer examId;
    private Integer studentId;
    private int grade;

}
