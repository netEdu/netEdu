package com.netEdu.lesson.apply.controller;

import com.netEdu.entity.Course;
import com.netEdu.lesson.apply.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("/Course")
@Api(description = "|教师端|课程申请")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @ApiOperation(value = "|Course|申请课程",notes = "course_name:课程名称</br>" +
            "credit:学分</br>" +
            "hours:课时</br>" +
            "teacher_id:教师id</br>" +
            "class_time:学时</br>" +
            "course_introduce:课程简介</br>" +
            "class_num:班号</br>" +
            "assessment_method:考核方法")
    @PostMapping(value = "/applyCourse")
    public String add(@RequestBody Course course){
        return courseService.add(course);
    }

    @ApiOperation(value = "|Course|修改申请",notes = "course_id:课程id" +
            "course_name:课程名称</br>" +
            "credit:学分</br>" +
            "hours:课时</br>" +
            "class_time:学时</br>" +
            "course_introduce:课程简介</br>" +
            "class_num:班号</br>" +
            "assessment_method:考核方法")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE,value = "/updateApplication")
    public void update(@RequestBody Course course){
        courseService.updateCourse(course);
    }

    @ApiOperation(value = "|Course|取消申请",notes = "ids:课程id组 split by ','")
    @DeleteMapping(value = "/cancelCourse")
    public void del(@RequestParam String ids){
        courseService.remove(ids);
        System.out.println("删除------------------"+ids);
    }

    @ApiOperation(value = "|Course|查看申请列表",notes = "teacher_id:教师id</br>" +
            "course_name:课程名称 模糊</br>" +
            "course_introduce:课程简介 模糊</br>" +
            "class_num:班号</br>" +
            "audit_status:审核状态 0:待审 1:通过 2:不行")
    @PostMapping(value = "/courseList")
    public List<Course> query(@RequestBody Course course){
        return courseService.selectCourse(course);
    }

}
