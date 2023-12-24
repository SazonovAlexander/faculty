package ru.vsu.cs.sazonov.faculty.api.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Data
@Builder
public class StudentExamDto {

    private StudentDto student;
    private ExamDto exam;
    private int grade;

}
