package ru.vsu.cs.sazonov.faculty.item.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Generated;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "course")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @Generated
    private Integer id;
    private String name;

    @Transient
    @OneToMany(mappedBy = "course")
    private List<Exam> exams;

    @OneToMany(mappedBy = "pk.course",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Schedule> schedules;

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
