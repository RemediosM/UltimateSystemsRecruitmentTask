package com.us.ultimatesystemsrecruitmenttask.service;

import com.us.ultimatesystemsrecruitmenttask.model.Student;
import com.us.ultimatesystemsrecruitmenttask.model.StudentRepository;
import com.us.ultimatesystemsrecruitmenttask.model.Teacher;
import com.us.ultimatesystemsrecruitmenttask.model.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final TeacherService teacherService;

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student editStudent(Student student) {
        return studentRepository.save(student);
    }

    public void removeStudentById(long id) {
        studentRepository.deleteById(id);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudent(long id, Student student) {
        student.setId(id);
        return studentRepository.save(student);
    }

    public List<Student> findAllByNameAndSurname(String firstName, String lastName) {
        return studentRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public List<Teacher> findAllTeachersForStudent(long studentId) {
        return teacherRepository.findAllByStudents(studentId);
    }

    public void addTeacherToStudent(long studentId, long teacherId) { // todo
        Student student = getStudentById(studentId);
        Teacher teacher = teacherService.getTeacherById(teacherId);
        if (student == null || teacher == null) {
            // todo zwróć info o braku
        }
        student.addTeacher(teacher);
    }

}
