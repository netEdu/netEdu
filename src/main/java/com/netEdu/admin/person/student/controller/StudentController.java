package com.netEdu.admin.person.student.controller;

import com.adc.da.base.web.BaseController;
import com.adc.da.util.http.PageInfo;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.netEdu.admin.person.student.service.StudentService;
import com.netEdu.admin.person.student.vo.StudentPage;
import com.netEdu.entity.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Person")
@Api(description = "|管理员端|学生管理")
public class StudentController extends BaseController<Student>{

    @Autowired
    private StudentService studentService;

    @ApiOperation(value = "|Student|添加学生",notes = "username:学生登录名</br>" +
            "name:学生姓名</br>" +
            "sex:性别</br>" +
            "identity:身份证号</br>" +
            "birth:出生日期</br>" +
            "origin:籍贯</br>" +
            "email:邮箱</br>" +
            "phone:联系方式</br>" +
            "class_num:班级")
    @PostMapping(value = "/addStudent")
    public void addS(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @ApiOperation(value = "|Student|分页按条件查询学生",notes = "name:教师姓名 模糊</br>" +
            "sex:性别</br>" +
            "class_num:班号</br>" +
            "page:页码</br>" +
            "pageSize:页容量")
    @PostMapping(value = "/queryStudent")
    public ResponseMessage<PageInfo<Student>> queryS(@RequestBody StudentPage studentPage){
        return Result.success(getPageInfo(studentPage.getPager(), studentService.queryStudent(studentPage)));
    }

    @ApiOperation(value = "|Student|失去焦点时登录名查重",notes = "username:登录名")
    @GetMapping(value = "/checkStudent")
    public String checkUsername(@RequestParam String username){
        return studentService.check(username);
    }

}
