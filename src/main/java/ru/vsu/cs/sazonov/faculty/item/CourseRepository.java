package ru.vsu.cs.sazonov.faculty.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.sazonov.faculty.item.model.Course;

import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
