package com.us.ultimatesystemsrecruitmenttask.model;


import com.us.ultimatesystemsrecruitmenttask.dto.StudentDto;
import com.us.ultimatesystemsrecruitmenttask.dto.TeacherDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Teacher {

    @Id
    @GeneratedValue
    private Long id;
    @Size(min = 2)
    private String firstName;
    private String lastName;
    @Min(value = 18)
    @NotNull
    private Long age;
    @Email
    private String email;
    private String subject;
    @ManyToMany(mappedBy = "teachers")
    private Set<Student> students;

    public Teacher(Long id, String firstName, String lastName, Long age, String email, String subject, Set<Student> students) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.subject = subject;
        this.students = students == null ? new HashSet<>() : students;
    }

    public TeacherDto toDto() {
        Set<StudentDto> studentDtos = students.stream()
                .map(Student::toDto)
                .collect(Collectors.toSet());
        return new TeacherDto(id, firstName, lastName, age, email, subject, studentDtos);
    }

    public void addStudent(Student student) {
        students.add(student);
    }
}
