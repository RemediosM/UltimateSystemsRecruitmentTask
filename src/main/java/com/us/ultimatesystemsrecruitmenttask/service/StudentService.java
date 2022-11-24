package com.us.ultimatesystemsrecruitmenttask.service;

import com.us.ultimatesystemsrecruitmenttask.model.Student;

import java.util.List;

public interface StudentService {

    Student addStudent(Student student);

    Student editStudent(Student student);

    void removeStudentById(long id);

    Student getStudentById(Long id);

    Student updateStudent(long id, Student student);

    void addTeacherToStudent(long studentId, long teacherId);

    List<Student> findAllByNameAndLastName(String firstName, String lastName);

}
