package ru.vsu.cs.sazonov.faculty.item.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;

import java.util.List;

@Entity
@Table(name = "party")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Party {

    @Id
    @Generated
    private Integer id;
    private int number;
    private int year;

    @Transient
    @OneToMany(mappedBy = "party")
    private List<Exam> exams;

    @Transient
    @OneToMany(mappedBy = "party")
    private List<Student> students;

    @OneToMany(mappedBy = "pk.party",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Schedule> schedules;

    @Override
    public String toString() {
        return "Party{" +
                "id=" + id +
                ", number=" + number +
                ", year=" + year +
                '}';
    }
}
