package ru.vsu.cs.sazonov.faculty.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.vsu.cs.sazonov.faculty.api.model.ExamDto;
import ru.vsu.cs.sazonov.faculty.api.model.PartyDto;
import ru.vsu.cs.sazonov.faculty.item.model.Exam;
import ru.vsu.cs.sazonov.faculty.item.model.Party;

import java.util.List;
@Mapper
public interface PartyMapper {
    PartyMapper INSTANCE = Mappers.getMapper(PartyMapper.class);
    PartyDto toDto(Party item);

    List<PartyDto> toDto(List<Party> items);

    Party mapToItem(PartyDto dto);
}
