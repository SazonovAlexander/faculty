package ru.vsu.cs.sazonov.faculty.item.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "schedule")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {

    @EmbeddedId
    private SchedulePK pk;

    private String day;

    private String time;


}
