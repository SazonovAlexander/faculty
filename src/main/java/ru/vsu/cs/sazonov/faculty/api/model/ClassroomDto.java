package ru.vsu.cs.sazonov.faculty.api.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Data
@Builder
public class ClassroomDto {

    private Integer id;
    private int floor;
    private int number;
}
