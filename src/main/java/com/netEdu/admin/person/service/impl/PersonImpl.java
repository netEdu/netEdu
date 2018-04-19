package com.netEdu.admin.person.service.impl;

import com.netEdu.admin.person.dao.StudentMapper;
import com.netEdu.admin.person.dao.TeacherMapper;
import com.netEdu.admin.person.service.PersonService;
import com.netEdu.entity.Student;
import com.netEdu.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class PersonImpl implements PersonService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public void addTeacher(Teacher teacher) {
        Date date=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        teacher.setCreate_time(df.format(date));
        teacherMapper.insertSelective(teacher);
    }

    @Override
    public void addStudent(Student student) {
        studentMapper.insertSelective(student);
    }

}
