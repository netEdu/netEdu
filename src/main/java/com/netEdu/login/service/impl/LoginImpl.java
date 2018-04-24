package com.netEdu.login.service.impl;

import com.netEdu.entity.Teacher;
import com.netEdu.login.dao.LoginMapper;
import com.netEdu.entity.Student;
import com.netEdu.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginImpl implements LoginService {

@Autowired
private LoginMapper loginMapper;


    @Override
    public String Login(Student student) {
        if ("admin".equals(student.getUsername()) && "admin".equals(student.getPassword())){
            return "ADMIN";
        }
        Teacher teacher =new Teacher();
        teacher.setUsername(student.getUsername());
        teacher.setPassword(student.getPassword());
           List<Teacher> result0= loginMapper.loginTeacher(teacher);
           List<Student> result= loginMapper.login(student);
           if(result.size()==0 && result0.size()==0){
               return "BAD REQUEST";
           }
            if(result.size()==0){
               return "Teacher:"+result0.get(0).getTeacher_id()+"";
            }
        return "Student:"+result.get(0).getClass_num()+","+result.get(0).getStudent_id();
    }

}
