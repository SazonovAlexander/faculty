package ru.vsu.cs.sazonov.faculty.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.sazonov.faculty.item.model.*;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, SchedulePK> {

    List<Schedule> findByPkCourse (Course course);

    List<Schedule> findByPkParty (Party party);

    List<Schedule> findByPkClassroom (Classroom classroom);

    List<Schedule> findByPkTeacher (Teacher teacher);


}
