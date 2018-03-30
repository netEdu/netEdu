package com.netEdu.login.controller;

import com.netEdu.login.entity.Student;
import com.netEdu.login.service.impl.StudentImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/")
public class LoginController{

    @Autowired
    private StudentImpl studentImpl;

    @PostMapping ("/login")
    public String login(@RequestBody Student student){
        return studentImpl.studentLogin(student);
    }


}
