package com.netEdu.admin.verify.controller;

import com.netEdu.admin.verify.service.CourseVerifyService;
import com.netEdu.entity.Course;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Admin")
@Api(description = "|管理员端|课程审核")
public class CourseVerifyController {

    @Autowired
    private CourseVerifyService courseVerifyService;

    @ApiOperation(value = "|Admin|查看申请列表",notes = "course_name:课程名称 模糊</br>" +
            "name:教师姓名 模糊</br>" +
            "class_num:班号</br>" +
            "audit_status:审核状态")
    @PostMapping(value = "/courseList")
    public List<Course> query(@RequestBody Course course){
        return courseVerifyService.queryCourseList(course);
    }

    @ApiOperation(value = "|Admin|审核",notes = "course_id:课程id</br>" +
            "audit_status:审核状态</br>" +
            "audit_opinion:审核意见")
    @PutMapping(value = "/verify")
    public void update(@RequestBody Course course){
        courseVerifyService.verify(course);
    }

}
