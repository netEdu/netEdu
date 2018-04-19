package com.netEdu.admin.person.controller;

import com.netEdu.admin.person.service.PersonService;
import com.netEdu.entity.Student;
import com.netEdu.entity.Teacher;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Person")
@Api(description = "|管理员端|人员管理")
public class PersonController {

    @Autowired
    private PersonService personService;

    @ApiOperation(value = "|Person|添加教师",notes = "username:教师登录名</br>" +
            "name:教师姓名</br>" +
            "sex:性别</br>" +
            "identity:身份证号</br>" +
            "birth:出生日期</br>" +
            "origin:籍贯</br>" +
            "email:邮箱</br>" +
            "phone:联系方式</br>" +
            "position:职位")
    @PostMapping(value = "/addTeacher")
    public void addT(@RequestBody Teacher teacher){
        personService.addTeacher(teacher);
    }

    @PostMapping(value = "/addStudent")
    public void addS(@RequestBody Student student){
        personService.addStudent(student);
    }

}
