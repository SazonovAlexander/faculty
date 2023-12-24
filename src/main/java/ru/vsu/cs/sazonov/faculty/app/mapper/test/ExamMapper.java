package ru.vsu.cs.sazonov.faculty.app.mapper.test;

import org.mapstruct.Mapper;
import ru.vsu.cs.sazonov.faculty.api.model.StudentExamDto;
import ru.vsu.cs.sazonov.faculty.api.model.StudentExamPKDto;
import ru.vsu.cs.sazonov.faculty.item.model.StudentExam;
import ru.vsu.cs.sazonov.faculty.item.model.StudentExamPK;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class ExamMapper {

    public abstract StudentExamPK mapDtoToItem(StudentExamPKDto schedulePKDto);
    public abstract StudentExamPKDto mapItemToDto(StudentExamPK schedulePK);

    public StudentExam mapDtoToStudentExam(StudentExamDto studentExamDto) {
        StudentExamPK studentExamPK = mapDtoToItem(StudentExamPKDto.builder()
                .student(studentExamDto.getStudent())
                .exam(studentExamDto.getExam()).build());
        return StudentExam.builder().pk(studentExamPK).grade(studentExamDto.getGrade()).build();
    };

    public StudentExamDto mapStudentExamToDto(StudentExam studentExam) {
        StudentExamPKDto schedulePKDto = mapItemToDto(studentExam.getPk());
        return StudentExamDto.builder()
                .exam(schedulePKDto.getExam())
                .student(schedulePKDto.getStudent())
                .grade(studentExam.getGrade())
                .build();
    }

    public List<StudentExamDto> mapStudentExamToDto(List<StudentExam> studentExams) {
        return studentExams.stream()
                .map(this::mapStudentExamToDto)
                .collect(Collectors.toList());
    }
}
