package ru.vsu.cs.sazonov.faculty.api.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Data
@Builder
public class PartyDto {

    private Integer id;
    private int number;
    private int year;

}
