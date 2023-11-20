package ru.vsu.cs.sazonov.faculty.app.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.sazonov.faculty.api.PartyApi;
import ru.vsu.cs.sazonov.faculty.api.model.PartyDto;
import ru.vsu.cs.sazonov.faculty.api.model.StudentDto;
import ru.vsu.cs.sazonov.faculty.app.mapper.PartyMapper;
import ru.vsu.cs.sazonov.faculty.app.mapper.StudentMapper;
import ru.vsu.cs.sazonov.faculty.app.service.PartyService;
import ru.vsu.cs.sazonov.faculty.item.PartyRepository;
import ru.vsu.cs.sazonov.faculty.item.model.Party;
import ru.vsu.cs.sazonov.faculty.item.model.Student;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class PartyController implements PartyApi {

    private final PartyService partyService;

    @Override
    public ResponseEntity<List<StudentDto>> getStudents(Integer partyId) {
        List<Student> students = partyService.getStudents(partyId);
        List<StudentDto> studentDtos = StudentMapper.INSTANCE.toDto(students);
        return ResponseEntity.ok(studentDtos);
    }

    @Override
    public ResponseEntity<List<PartyDto>> getAllParty() {
        List<Party> parties = partyService.getAllParty();
        List<PartyDto> partyDtos = PartyMapper.INSTANCE.toDto(parties);
        return ResponseEntity.ok(partyDtos);
    }

    @Override
    public ResponseEntity<PartyDto> getParty(Integer partyId) {
        Party party = partyService.getParty(partyId);
        PartyDto partyDto = PartyMapper.INSTANCE.toDto(party);
        return ResponseEntity.ok(partyDto);
    }

    @Override
    public ResponseEntity<PartyDto> createParty(PartyDto party) {
        Party partyItem = PartyMapper.INSTANCE.mapToItem(party);
        Party createdParty = partyService.createParty(partyItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(PartyMapper.INSTANCE.toDto(createdParty));
    }

    @Override
    public ResponseEntity<PartyDto> updateParty(Integer partyId, PartyDto party) {
        Party currentParty = partyService.getParty(partyId);
        Party newParty = PartyMapper.INSTANCE.mapToItem(party);
        currentParty.setNumber(newParty.getNumber());
        currentParty.setYear(newParty.getYear());

        Party updatedParty = partyService.updateParty(currentParty);
        return ResponseEntity.ok(PartyMapper.INSTANCE.toDto(updatedParty));
    }

    @Override
    public ResponseEntity<PartyDto> deleteParty(Integer partyId) {
        partyService.deleteParty(partyId);
        return ResponseEntity.ok().build();
    }


}
