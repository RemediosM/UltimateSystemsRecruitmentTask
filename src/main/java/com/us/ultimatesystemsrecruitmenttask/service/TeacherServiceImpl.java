package com.us.ultimatesystemsrecruitmenttask.service;

import com.us.ultimatesystemsrecruitmenttask.model.Teacher;
import com.us.ultimatesystemsrecruitmenttask.model.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher getTeacherById(long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    public void removeTeacherById(long id) {
        teacherRepository.deleteById(id);
    }

    public Teacher updateTeacher(long id, Teacher teacher) {
        teacher.setId(id);
        return teacherRepository.save(teacher);
    }

}
