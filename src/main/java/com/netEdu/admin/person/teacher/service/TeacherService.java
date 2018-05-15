package com.netEdu.admin.person.teacher.service;

import com.netEdu.admin.person.teacher.vo.TeacherPage;
import com.netEdu.entity.Teacher;

import java.util.List;

public interface TeacherService {

    void addTeacher(Teacher teacher);

    List<Teacher> queryTeacher(TeacherPage teacherPage);

    String check(String username);

    List<Teacher> selectAllTeacher();
}
