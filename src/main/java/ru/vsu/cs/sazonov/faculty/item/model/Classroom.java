package ru.vsu.cs.sazonov.faculty.item.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "classroom")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Classroom {

    @Id
    @Generated
    private Integer id;
    private int floor;
    private int number;

    @Transient
    @OneToMany(mappedBy = "classroom")
    private List<Exam> exams;

    @OneToMany(mappedBy = "pk.classroom",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Schedule> schedules;

    @Override
    public String toString() {
        return "Classroom{" +
                "id=" + id +
                ", floor=" + floor +
                ", number=" + number +
                '}';
    }
}
