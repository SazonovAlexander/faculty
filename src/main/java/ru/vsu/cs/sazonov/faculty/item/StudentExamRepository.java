package ru.vsu.cs.sazonov.faculty.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.sazonov.faculty.item.model.Exam;
import ru.vsu.cs.sazonov.faculty.item.model.Student;
import ru.vsu.cs.sazonov.faculty.item.model.StudentExam;
import ru.vsu.cs.sazonov.faculty.item.model.StudentExamPK;

import java.util.List;
@Repository
public interface StudentExamRepository extends JpaRepository<StudentExam, StudentExamPK> {

    List<StudentExam> findByPkStudent (Student student);
    List<StudentExam> findByPkExam (Exam exam);

}
