package com.netEdu.client.student.service;

import com.netEdu.entity.Course;
import com.netEdu.entity.Group;
import com.netEdu.entity.Student;

import java.util.List;

public interface StudentClientService {

    Student personalInfo(int student_id);

    void updateInfo(Student student);

    List<Course> queryCourse(int student_id);

}
