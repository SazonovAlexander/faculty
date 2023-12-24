package ru.vsu.cs.sazonov.faculty.specification;

import org.springframework.data.jpa.domain.Specification;
import ru.vsu.cs.sazonov.faculty.item.model.Student;

public class StudentSpecifications {
    public static Specification<Student> hasFullName(String fullName) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("fullName"), "%" + fullName + "%");
    }
}
