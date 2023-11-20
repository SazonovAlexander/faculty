package ru.vsu.cs.sazonov.faculty.item.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Generated;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "teacher")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    @Id
    @Generated
    private Integer id;

    @Column(name = "full_name")
    private String fullName;

    private String email;
    private String degree;

    @OneToMany(mappedBy = "pk.teacher",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Schedule> schedules;
}
