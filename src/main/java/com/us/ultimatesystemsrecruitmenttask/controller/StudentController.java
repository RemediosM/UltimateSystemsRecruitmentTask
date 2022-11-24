package com.us.ultimatesystemsrecruitmenttask.controller;

import com.us.ultimatesystemsrecruitmenttask.model.Student;
import com.us.ultimatesystemsrecruitmenttask.dto.StudentDto;
import com.us.ultimatesystemsrecruitmenttask.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping(value = "new")
    public ResponseEntity addStudent(@RequestBody StudentDto studentDto) {
        Student student = studentService.addStudent(studentDto.toEntity());
        return ResponseEntity.status(201)
                .body(student.toDto());
    }

    @GetMapping(value = "{id}")
    public ResponseEntity getStudent(@PathVariable("id") long id) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            return ResponseEntity.status(404)
                    .body("Student not found");
        }
        return ResponseEntity.status(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body(student.toDto());
    }

    @PutMapping(value = "{id}/edit")
    public ResponseEntity updateStudent(@PathVariable("id") long id, @RequestBody StudentDto studentDto) {
        Student student = studentService.updateStudent(id, studentDto.toEntity());
        return ResponseEntity.status(200)
                .body(student.toDto());
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity removeStudent(@PathVariable("id") long id) {
        studentService.removeStudentById(id);
        return ResponseEntity.status(204)
                .body("Student has been removed");
    }

}
