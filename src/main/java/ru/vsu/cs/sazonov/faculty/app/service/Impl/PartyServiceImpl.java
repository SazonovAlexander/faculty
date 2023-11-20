package ru.vsu.cs.sazonov.faculty.app.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vsu.cs.sazonov.faculty.app.exception.NotFoundException;
import ru.vsu.cs.sazonov.faculty.app.service.PartyService;
import ru.vsu.cs.sazonov.faculty.item.PartyRepository;
import ru.vsu.cs.sazonov.faculty.item.StudentRepository;
import ru.vsu.cs.sazonov.faculty.item.model.Party;
import ru.vsu.cs.sazonov.faculty.item.model.Student;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PartyServiceImpl implements PartyService {

    private final PartyRepository partyRepository;
    private final StudentRepository studentRepository;


    @Override
    public List<Student> getStudents(Integer partyId) {
        Party party = partyRepository.findById(partyId).orElseThrow(() -> new NotFoundException("Book with this id not found"));
        return studentRepository.findAllByParty(party);
    }

    @Override
    public List<Party> getAllParty() {
        return partyRepository.findAll();
    }

    @Override
    public Party getParty(Integer partyId) {
        return partyRepository.findById(partyId).orElseThrow(() -> new NotFoundException("Book with this id not found"));
    }

    @Override
    public Party createParty(Party party) {
        return updateParty(party);
    }

    @Override
    public Party updateParty(Party party) {
        return partyRepository.saveAndFlush(party);
    }

    @Override
    public void deleteParty(Integer partyId) {
        partyRepository.deleteById(partyId);
    }
}
