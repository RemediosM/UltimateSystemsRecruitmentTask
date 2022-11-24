package com.us.ultimatesystemsrecruitmenttask.controller;

import com.us.ultimatesystemsrecruitmenttask.model.Teacher;
import com.us.ultimatesystemsrecruitmenttask.dto.TeacherDto;
import com.us.ultimatesystemsrecruitmenttask.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping(value = "new")
    public ResponseEntity addTeacher(@RequestBody TeacherDto teacherDto) {
        Teacher teacher = teacherService.addTeacher(teacherDto.toEntity());
        return ResponseEntity.status(201)
                .body(teacher.toDto());
    }

    @GetMapping(value = "{id}")
    public ResponseEntity getTeacher(@PathVariable("id") long id) {
        Teacher teacher = teacherService.getTeacherById(id);
        if (teacher == null) {
            return ResponseEntity.status(404)
                    .body("Teacher not found");
        }
        return ResponseEntity.status(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body(teacher.toDto());
    }

    @PutMapping(value = "{id}")
    public ResponseEntity updateTeacher(@PathVariable("id") long id, @RequestBody TeacherDto teacherDto) {
        Teacher teacher = teacherService.updateTeacher(id, teacherDto.toEntity());
        return ResponseEntity.status(200)
                .body(teacher.toDto());
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity removeTeacher(@PathVariable("id") long id) {
        teacherService.removeTeacherById(id);
        return ResponseEntity.status(204)
                .body("Teacher has been removed");
    }

}
