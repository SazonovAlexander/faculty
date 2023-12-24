package ru.vsu.cs.sazonov.faculty.app.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.vsu.cs.sazonov.faculty.app.exception.NotFoundException;
import ru.vsu.cs.sazonov.faculty.app.service.PartyService;
import ru.vsu.cs.sazonov.faculty.item.PartyRepository;
import ru.vsu.cs.sazonov.faculty.item.StudentRepository;
import ru.vsu.cs.sazonov.faculty.item.model.Party;
import ru.vsu.cs.sazonov.faculty.item.model.Student;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartyServiceImpl implements PartyService {

    private final PartyRepository partyRepository;
    private final StudentRepository studentRepository;


    @Override
    public List<Student> getStudents(Integer partyId, PageRequest pageRequest) {
        Party party = partyRepository.findById(partyId).orElseThrow(() -> new NotFoundException("Book with this id not found"));
        return studentRepository.findAllByParty(party, pageRequest);
    }

    @Override
    public List<Party> getAllParty(PageRequest pageRequest) {
        return partyRepository.findAll(pageRequest).getContent();
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
