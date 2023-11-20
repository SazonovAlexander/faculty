package ru.vsu.cs.sazonov.faculty.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.sazonov.faculty.item.model.Classroom;

import java.util.UUID;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {
}
