package com.netEdu.client.student.service.impl;

import com.netEdu.client.student.dao.StudentClientMapper;
import com.netEdu.client.student.service.StudentClientService;
import com.netEdu.entity.Course;
import com.netEdu.entity.Group;
import com.netEdu.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentClientImpl implements StudentClientService{

    @Autowired
    private StudentClientMapper studentClientMapper;

    @Override
    public Student personalInfo(int student_id) {
        return studentClientMapper.selectById(student_id);
    }

    @Override
    public void updateInfo(Student student) {
        studentClientMapper.updateByPrimaryKeySelective(student);
    }

    @Override
    public List<Course> queryCourse(int student_id) {
        return studentClientMapper.selectCourseById(student_id);
    }

}
