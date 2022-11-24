package com.us.ultimatesystemsrecruitmenttask.dto;

import com.us.ultimatesystemsrecruitmenttask.model.Student;
import com.us.ultimatesystemsrecruitmenttask.model.Teacher;
import lombok.*;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class TeacherDto {

    private Long id;
    private String firstName;
    private String name;
    private Long age;
    private String email;
    private String faculty;
    private Set<StudentDto> students;

    public Teacher toEntity() {
        Set<Student> studentEntities = this.students == null ? null : this.students.stream().map(StudentDto::toEntity).collect(Collectors.toSet());
        return new Teacher(id, firstName, name, age, email, faculty, studentEntities);
    }
}
