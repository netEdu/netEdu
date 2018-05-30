package com.netEdu.client.teacher.service.impl;

import com.netEdu.client.teacher.dao.TeacherClientMapper;
import com.netEdu.client.teacher.service.TeacherClientService;
import com.netEdu.entity.Course;
import com.netEdu.entity.Paper;
import com.netEdu.entity.Student;
import com.netEdu.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherClientImpl implements TeacherClientService {

    @Autowired
    private TeacherClientMapper teacherClientMapper;

    @Override
    public Teacher personalInfo(int teacher_id) {
        return teacherClientMapper.selectById(teacher_id);
    }

    @Override
    public void updateInfo(Teacher teacher) {
        teacherClientMapper.updateByPrimaryKeySelective(teacher);
    }

    @Override
    public List<Course> queryCourse(int teacher_id) {
        return teacherClientMapper.selectCourseById(teacher_id);
    }

    @Override
    public List<Student> queryStudent(int teacher_id) {
        return teacherClientMapper.selectMyStudent(teacher_id);
    }

    @Override
    public List<Paper> queryPaper(int student_id) {
        return teacherClientMapper.selectMyStudentPaper(student_id);
    }
}
