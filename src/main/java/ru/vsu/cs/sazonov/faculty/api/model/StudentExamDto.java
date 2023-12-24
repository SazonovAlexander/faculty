package ru.vsu.cs.sazonov.faculty.api.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Data
@Builder
public class StudentExamDto {

    private StudentExamPKDto pk;
    private int grade;

}
