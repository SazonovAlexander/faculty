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
@Table(name = "student")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @Generated
    private Integer id;

    @Column(name = "full_name")
    private String fullName;

    private String email;
    private String address;

    @ManyToOne()
    private Party party;

    @Transient
    @OneToMany(mappedBy = "pk.student",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<StudentExam> studentExams;


}

