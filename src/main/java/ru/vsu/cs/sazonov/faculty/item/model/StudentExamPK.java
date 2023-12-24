package ru.vsu.cs.sazonov.faculty.item.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentExamPK implements Serializable {

    @ManyToOne()
    @JoinColumn(name = "student_id")

    private Student student;

    @ManyToOne()
    @JoinColumn(name = "exam_id")

    private Exam exam;



}
