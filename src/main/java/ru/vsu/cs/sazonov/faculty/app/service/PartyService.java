package ru.vsu.cs.sazonov.faculty.app.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import ru.vsu.cs.sazonov.faculty.item.model.Party;
import ru.vsu.cs.sazonov.faculty.item.model.Student;

import java.util.List;

public interface PartyService {


    List<Student> getStudents(Integer partyId, Sort by);
    List<Party> getAllParty(PageRequest pageRequest);

    Party getParty(Integer partyId);

    Party createParty(Party party);

    Party updateParty(Party party);

    void deleteParty(Integer partyId);



}
