package com.us.ultimatesystemsrecruitmenttask.service;

import com.us.ultimatesystemsrecruitmenttask.model.Teacher;

public interface TeacherService {

    Teacher addTeacher(Teacher teacher);

    Teacher getTeacherById(long id);

    void removeTeacherById(long id);

    Teacher updateTeacher(long id, Teacher teacher);

}
