package com.netEdu.login.controller;

import com.netEdu.entity.Student;
import com.netEdu.login.service.impl.LoginImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/")
@Api(description = "|登录|")
public class LoginController{

    @Autowired
    private LoginImpl studentImpl;
    @ApiOperation(value = "|登录|用户登录",notes =
            "username:用户名 </br>" +
            "password:密码")
    @PostMapping ("/login")
    public String login(@RequestBody Student student){
        return studentImpl.Login(student);
    }


}
