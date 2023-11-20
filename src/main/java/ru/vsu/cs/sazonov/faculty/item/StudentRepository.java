package ru.vsu.cs.sazonov.faculty.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.sazonov.faculty.item.model.Party;
import ru.vsu.cs.sazonov.faculty.item.model.Student;
import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAllByParty (Party party);

}
