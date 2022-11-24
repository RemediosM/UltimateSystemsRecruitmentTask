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
public class StudentDto {

    private Long id;
    private String firstName;
    private String lastName;
    private Long age;
    private String email;
    private String subject;
    private Set<TeacherDto> teachers;

    public Student toEntity() {
        Set<Teacher> teacherEntities = this.teachers == null ? null : this.teachers.stream().map(TeacherDto::toEntity).collect(Collectors.toSet());
        return new Student(id, firstName, lastName, age, email, subject, teacherEntities);
    }
}
