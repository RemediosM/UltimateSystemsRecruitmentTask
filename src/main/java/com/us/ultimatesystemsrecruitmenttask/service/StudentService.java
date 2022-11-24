package com.us.ultimatesystemsrecruitmenttask.service;

import com.us.ultimatesystemsrecruitmenttask.model.Student;

public interface StudentService {

    Student addStudent(Student student);

    Student editStudent(Student student);

    void removeStudentById(long id);

    Student getStudentById(Long id);

    Student updateStudent(long id, Student student);

    void addTeacherToStudent(long studentId, long teacherId);

}
