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
@Table(name = "exam")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Exam {

    @Id
    @Generated
    private Integer id;
    private String date;

    @ManyToOne(fetch = FetchType.LAZY)
    private Party party;

    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    private Classroom classroom;

    @OneToMany(mappedBy = "pk.exam",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<StudentExam> studentExams;



}
