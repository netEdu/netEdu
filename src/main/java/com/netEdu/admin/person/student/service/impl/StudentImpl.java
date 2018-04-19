package com.netEdu.admin.person.student.service.impl;

import com.netEdu.admin.person.student.dao.StudentMapper;
import com.netEdu.admin.person.student.service.StudentService;
import com.netEdu.admin.person.student.vo.StudentPage;
import com.netEdu.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StudentImpl implements StudentService{

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public void addStudent(Student student) {
        Date date=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        student.setCreate_time(df.format(date));
        student.setPassword("123456");
        studentMapper.insertSelective(student);
    }

    @Override
    public List<Student> queryStudent(StudentPage studentPage) {
        Integer rowCount = studentMapper.queryByCount(studentPage);
        studentPage.getPager().setRowCount(rowCount);
        return studentMapper.selectStudent(studentPage);
    }

}
