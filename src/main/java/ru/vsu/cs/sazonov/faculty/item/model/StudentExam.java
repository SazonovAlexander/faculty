package ru.vsu.cs.sazonov.faculty.item.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_exam")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentExam {

    @EmbeddedId
    private StudentExamPK pk;
    private int grade;



}
