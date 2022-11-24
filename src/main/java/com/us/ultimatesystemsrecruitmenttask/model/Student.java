package com.us.ultimatesystemsrecruitmenttask.model;

import com.us.ultimatesystemsrecruitmenttask.dto.StudentDto;
import com.us.ultimatesystemsrecruitmenttask.dto.TeacherDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    @Size(min = 2)
    private String lastName;
    @Min(value = 18)
    @NotNull
    private Long age;
    @Email
    private String email;
    private String faculty;
    @ManyToMany
    @JoinTable(name = "teacher_student", joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<Teacher> teachers;

    public Student(Long id, String firstName, String lastName, Long age, String email, String faculty, Set<Teacher> teachers) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.faculty = faculty;
        this.teachers = teachers == null ? new HashSet<>() : teachers;
    }

    public StudentDto toDto() {
        Set<TeacherDto> teacherDtos = teachers.stream()
                    .map(Teacher::toDto)
                    .collect(Collectors.toSet());
        return new StudentDto(id, firstName, lastName, age, email, faculty, teacherDtos);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

}
