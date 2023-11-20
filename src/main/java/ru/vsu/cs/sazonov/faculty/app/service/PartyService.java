package ru.vsu.cs.sazonov.faculty.app.service;

import ru.vsu.cs.sazonov.faculty.item.model.Party;
import ru.vsu.cs.sazonov.faculty.item.model.Student;

import java.util.List;
import java.util.UUID;

public interface PartyService {


    List<Student> getStudents(Integer partyId);
    List<Party> getAllParty();

    Party getParty(Integer partyId);

    Party createParty(Party party);

    Party updateParty(Party party);

    void deleteParty(Integer partyId);



}
