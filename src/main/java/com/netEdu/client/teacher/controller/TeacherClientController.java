package com.netEdu.client.teacher.controller;

import com.netEdu.client.teacher.service.TeacherClientService;
import com.netEdu.entity.Course;
import com.netEdu.entity.Paper;
import com.netEdu.entity.Student;
import com.netEdu.entity.Teacher;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Client")
@Api(description = "|教师端|个人信息管理")
public class TeacherClientController {

    @Autowired
    private TeacherClientService teacherClientService;

    @ApiOperation(value = "|Client|教师查看个人信息",notes = "teacher_id:教师id")
    @GetMapping(value = "/teacherInfo")
    public Teacher query(@RequestParam int teacher_id){
        return teacherClientService.personalInfo(teacher_id);
    }

    @ApiOperation(value = "|Client|教师修改个人信息",notes = "teacher_id:教师id</br>" +
            "password:登录密码</br>" +
            "email:邮箱</br>" +
            "phone:联系方式")
    @PutMapping(value = "/updateTeacherInfo")
    public void update(@RequestBody Teacher teacher){
        teacherClientService.updateInfo(teacher);
    }

    @ApiOperation(value = "|Client|教师查看个人课程",notes = "teacher_id:教师id")
    @GetMapping(value = "/queryTeacherCourse")
    public List<Course> queryC(@RequestParam int teacher_id){
        return teacherClientService.queryCourse(teacher_id);
    }

    @ApiOperation(value = "|Client|教师查看自己教的学生",notes = "teacher_id:教师id")
    @GetMapping(value = "/queryMyStudent")
    public List<Student> queryStudent(@RequestParam int teacher_id) {
        return teacherClientService.queryStudent(teacher_id);
    }

    @ApiOperation(value = "|Client|教师查看自己教的学生写的卷子",notes = "student_id:学生id")
    @GetMapping(value = "/queryMyStudentPaper")
    public List<Paper> queryP(@RequestParam int student_id) {
        return  teacherClientService.queryPaper(student_id);
    }

}
