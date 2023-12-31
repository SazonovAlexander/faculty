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

    @ManyToOne()
    private Party party;

    @ManyToOne()
    private Course course;

    @ManyToOne()
    private Classroom classroom;

    @Transient
    @OneToMany(mappedBy = "pk.exam",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<StudentExam> studentExams;



}
