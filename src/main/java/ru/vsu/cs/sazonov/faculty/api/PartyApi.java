package ru.vsu.cs.sazonov.faculty.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.sazonov.faculty.api.model.PartyDto;
import ru.vsu.cs.sazonov.faculty.api.model.StudentDto;

import java.util.List;
import java.util.UUID;

public interface PartyApi {



    @GetMapping("/students/{partyId}")
    ResponseEntity<List<StudentDto>> getStudents(
            @PathVariable("partyId")
            Integer partyId,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(required = false, defaultValue = "avg") String sortParam

    );


    @GetMapping("/party")
    ResponseEntity<List<PartyDto>> getAllParty(
        @RequestParam(required = false, defaultValue = "0") int page,
        @RequestParam(required = false, defaultValue = "10") int size
    );

    @GetMapping("/party/{partyId}")
    ResponseEntity<PartyDto> getParty(
            @PathVariable("partyId")
            Integer partyId
    );

    @PostMapping("/party")
    ResponseEntity<PartyDto> createParty(
            @RequestBody
            PartyDto party
    );

    @PutMapping("/party/{partyId}")
    ResponseEntity<PartyDto> updateParty(
            @PathVariable("partyId")
            Integer partyId,

            @RequestBody
            PartyDto party
    );

    @DeleteMapping("/party/{partyId}")
    ResponseEntity<PartyDto> deleteParty(
            @PathVariable("partyId")
            Integer partyId
    );

}
