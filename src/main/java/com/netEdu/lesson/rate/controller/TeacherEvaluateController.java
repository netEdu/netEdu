package com.netEdu.lesson.rate.controller;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.netEdu.entity.TeacherEvaluate;
import com.netEdu.lesson.rate.service.TeacherEvaluateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class TeacherEvaluateController {

    @Autowired
    private TeacherEvaluateService teacherEvaluateService;

    @ApiOperation(value = "|TeacherEvaluate|添加教师评价")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE,value = "/addTeacherEvaluate")
    public ResponseMessage<TeacherEvaluate> create(@ApiParam(value = "教师评价对象" ,required=true )@RequestBody TeacherEvaluate teacherEvaluate) throws Exception {
        teacherEvaluateService.addTeacherEvaluate(teacherEvaluate);
        return Result.success(teacherEvaluate);
    }
}
