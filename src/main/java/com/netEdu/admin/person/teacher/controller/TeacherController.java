package com.netEdu.admin.person.teacher.controller;

import com.adc.da.base.web.BaseController;
import com.adc.da.util.http.PageInfo;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.netEdu.admin.person.teacher.service.TeacherService;
import com.netEdu.admin.person.teacher.vo.TeacherPage;
import com.netEdu.entity.Teacher;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Person")
@Api(description = "|管理员端|教师管理")
public class TeacherController extends BaseController<Teacher>{

    @Autowired
    private TeacherService teacherService;

    @ApiOperation(value = "|Teacher|添加教师",notes = "username:教师登录名</br>" +
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
        teacherService.addTeacher(teacher);
    }

    @ApiOperation(value = "|Teacher|分页按条件查询教师",notes = "name:教师姓名 模糊</br>" +
            "sex:性别</br>" +
            "position:职位")
    @PostMapping(value = "/queryTeacher")
    public ResponseMessage<PageInfo<Teacher>> queryT(@RequestBody TeacherPage teacherPage){
        return Result.success(getPageInfo(teacherPage.getPager(), teacherService.queryTeacher(teacherPage)));
    }

    @ApiOperation(value = "|Teacher|失去焦点时登录名查重",notes = "username:登录名")
    @GetMapping(value = "/checkTeacher")
    public String checkUsername(@RequestParam String username){
        return teacherService.check(username);
    }

}
