package com.netEdu.admin.person.student.service;

import com.netEdu.admin.person.student.vo.StudentPage;
import com.netEdu.entity.Student;

import java.util.List;

public interface StudentService {

    void addStudent(Student student);

    List<Student> queryStudent(StudentPage studentPage);

    String check(String username);

}
