package com.netEdu.admin.verify.service;

import com.netEdu.entity.Course;

import java.util.List;

public interface CourseVerifyService {

    List<Course> queryCourseList(Course course);

    void verify(Course course);

}
