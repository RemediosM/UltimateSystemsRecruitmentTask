package com.us.ultimatesystemsrecruitmenttask.model;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TeacherRepository extends PagingAndSortingRepository<Teacher, Long> {

    List<Teacher> findAllByFirstNameAndLastName(String firstNname, String lastName);

    List<Teacher> findAllByStudents(long studentId);


}
