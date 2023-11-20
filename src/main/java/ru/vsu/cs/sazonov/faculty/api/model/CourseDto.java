package ru.vsu.cs.sazonov.faculty.api.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Data
@Builder
public class CourseDto {

    private Integer id;
    private String name;

}
