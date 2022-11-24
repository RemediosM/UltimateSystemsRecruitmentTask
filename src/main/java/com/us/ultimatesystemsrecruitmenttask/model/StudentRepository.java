package com.us.ultimatesystemsrecruitmenttask.model;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {

    List<Student> findByFirstNameAndLastName(String firstName, String lastName);

    List<Student> findAllByTeachers(long teacherId);
}
