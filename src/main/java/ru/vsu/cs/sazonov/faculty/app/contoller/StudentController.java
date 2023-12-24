package ru.vsu.cs.sazonov.faculty.app.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.sazonov.faculty.api.StudentApi;
import ru.vsu.cs.sazonov.faculty.api.model.StudentDto;
import ru.vsu.cs.sazonov.faculty.api.model.StudentExamDto;
import ru.vsu.cs.sazonov.faculty.app.mapper.PartyMapper;
import ru.vsu.cs.sazonov.faculty.app.mapper.StudentMapper;
import ru.vsu.cs.sazonov.faculty.app.service.StudentService;
import ru.vsu.cs.sazonov.faculty.item.model.Party;
import ru.vsu.cs.sazonov.faculty.item.model.Student;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class StudentController implements StudentApi {

    private final StudentService studentService;
    @Override
    public ResponseEntity<List<StudentDto>> getAllStudent(int page, int size, String sortParam) {
        List<Student> allStudent = studentService.getAllStudent(PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, sortParam)));
        List<StudentDto> dto = StudentMapper.INSTANCE.toDto(allStudent);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<List<StudentDto>> getStudentsWithFilter(String fullName, int page, int size) {
        List<Student> students = studentService.getAllStudent(fullName, PageRequest.of(page, size));
        return ResponseEntity.ok(StudentMapper.INSTANCE.toDto(students));
    }

    @Override
    public ResponseEntity<StudentDto> getStudent(Integer studentId) {
        Student student = studentService.getStudent(studentId);
        StudentDto dto = StudentMapper.INSTANCE.toDto(student);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<StudentDto> createStudent(StudentDto student) {
        Student studentItem = StudentMapper.INSTANCE.mapToItem(student);
        Student createdStudent = studentService.createStudent(studentItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(StudentMapper.INSTANCE.toDto(createdStudent));
    }

    @Override
    public ResponseEntity<StudentDto> updateStudent(Integer studentId, StudentDto student) {
        Student currentStudent = studentService.getStudent(studentId);
        Student newStudent = StudentMapper.INSTANCE.mapToItem(student);
        currentStudent.setFullName(newStudent.getFullName());
        currentStudent.setEmail(newStudent.getEmail());
        currentStudent.setParty(newStudent.getParty());
        currentStudent.setAddress(newStudent.getAddress());

        Student updatedStudent = studentService.updateStudent(currentStudent);
        return ResponseEntity.ok(StudentMapper.INSTANCE.toDto(updatedStudent));
    }

    @Override
    public ResponseEntity<StudentDto> deleteStudent(Integer studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok().build();
    }



}
