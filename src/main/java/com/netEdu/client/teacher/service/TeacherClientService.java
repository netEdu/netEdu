package com.netEdu.client.teacher.service;

import com.netEdu.entity.Course;
import com.netEdu.entity.Teacher;

import java.util.List;

public interface TeacherClientService {

    Teacher personalInfo(int teacher_id);

    void updateInfo(Teacher teacher);

    List<Course> queryCourse(int teacher_id);

}
