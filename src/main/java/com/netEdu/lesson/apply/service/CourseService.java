package com.netEdu.lesson.apply.service;

import com.netEdu.entity.Course;

import java.util.List;

public interface CourseService {

    String add(Course course);

    void updateCourse(Course course);

    void remove(String ids);

    List<Course> selectCourse(Course course);

}
