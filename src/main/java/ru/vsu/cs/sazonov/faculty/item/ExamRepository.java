package ru.vsu.cs.sazonov.faculty.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.sazonov.faculty.item.model.Exam;
@Repository
public interface ExamRepository extends JpaRepository<Exam, Integer> {
}
