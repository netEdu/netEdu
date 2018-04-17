package com.netEdu.login.service.impl;

import com.netEdu.login.dao.StudentMapper;
import com.netEdu.entity.Student;
import com.netEdu.login.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentImpl implements StudentService{

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public String studentLogin(Student student) {
           List<Student> result=studentMapper.login(student);
           if(result.size()==0){
               return null;
           }
        return result.get(0).getClass_num();
    }

}
