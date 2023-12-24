package ru.vsu.cs.sazonov.faculty.api.model;

import lombok.*;
import ru.vsu.cs.sazonov.faculty.item.model.Party;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Data
@Builder
public class StudentDto {

    private Integer id;
    private String fullName;
    private String email;
    private String address;
    private PartyDto party;
    private Double avg;
}
