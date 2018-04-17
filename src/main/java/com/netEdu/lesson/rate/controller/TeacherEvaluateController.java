package com.netEdu.lesson.rate.controller;

import com.adc.da.base.web.BaseController;
import com.adc.da.util.http.PageInfo;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.netEdu.entity.TeacherEvaluate;
import com.netEdu.lesson.rate.page.TeacherEvaluatePage;
import com.netEdu.lesson.rate.service.TeacherEvaluateService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Lei
 * Date: 2018-04-03
 * Time: 14:58
 */
@RestController
@RequestMapping("/TeacherEvaluate")
@Api(description = "|教师端|教师评价")
public class TeacherEvaluateController extends BaseController<TeacherEvaluate> {

    @Autowired
    private TeacherEvaluateService teacherEvaluateService;

    @ApiOperation(value = "|TeacherEvaluate|添加教师评价")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE,value = "/addTeacherEvaluate")

    public ResponseMessage<TeacherEvaluate> create(@ApiParam(value = "调查问卷id：questionnaire_id，" +
            "学生id：student_id，" +
            "学生答案：answers" ,required=true ) @RequestBody TeacherEvaluate teacherEvaluate) throws Exception {
        teacherEvaluateService.addTeacherEvaluate(teacherEvaluate);
        return Result.success(teacherEvaluate);
    }
    @ApiOperation(value = "|TeacherEvaluate|修改教师评价")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE,value = "/upTeacherEvaluate")
    public ResponseMessage<TeacherEvaluate> upTeacherEvaluate(@ApiParam(value = "教师评价对象" ,required=false )@RequestBody TeacherEvaluate teacherEvaluate) throws Exception {
        teacherEvaluateService.upTeacherEvaluate(teacherEvaluate);
        return Result.success(teacherEvaluate);
    }
    @ApiOperation(value = "|TeacherEvaluate|分页查询")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE,value = "/page")
    public ResponseMessage<PageInfo<TeacherEvaluate>> page(@ApiParam(value = "传入page页码，pageSize页容量" ,required=false )@RequestBody TeacherEvaluatePage page) throws Exception {

        List<TeacherEvaluate> rows = teacherEvaluateService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }
    @ApiOperation(value = "|TeacherEvaluate|删除教师评价")
    @DeleteMapping(value = "/deleteTeacherEvaluate")
    public void deleteTeacherEvaluate(@RequestParam String ids){
        teacherEvaluateService.deleteTeacherEvaluate(ids);
    }


}
