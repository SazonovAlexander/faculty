package ru.vsu.cs.sazonov.faculty.api.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Data
@Builder
public class TeacherDto {

    private Integer id;
    private String fullName;
    private String email;
    private String degree;

}
