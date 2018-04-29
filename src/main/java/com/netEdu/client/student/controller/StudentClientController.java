package com.netEdu.client.student.controller;

import com.netEdu.client.student.service.StudentClientService;
import com.netEdu.entity.Course;
import com.netEdu.entity.Group;
import com.netEdu.entity.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Client")
@Api(description = "|学生端|个人信息管理")
public class StudentClientController {

    @Autowired
    private StudentClientService studentClientService;

    @ApiOperation(value = "|Client|学生查看个人信息",notes = "student_id:学生id")
    @GetMapping(value = "/studentInfo")
    public Student query(@RequestParam int student_id){
        return studentClientService.personalInfo(student_id);
    }

    @ApiOperation(value = "|Client|学生修改个人信息",notes = "student_id:学生id</br>" +
            "password:登录密码</br>" +
            "email:邮箱</br>" +
            "phone:联系方式")
    @PutMapping(value = "/updateStudentInfo")
    public void update(@RequestBody Student student){
        studentClientService.updateInfo(student);
    }

    @ApiOperation(value = "|Client|学生查看个人课程",notes = "student_id:学生id")
    @GetMapping("/queryStudentCourse")
    public List<Course> queryC(@RequestParam int student_id){
        return studentClientService.queryCourse(student_id);
    }

}
