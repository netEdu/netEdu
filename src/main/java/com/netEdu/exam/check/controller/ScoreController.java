package com.netEdu.exam.check.controller;

import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.netEdu.entity.Answer;
import com.netEdu.exam.check.service.CheckService;
import com.netEdu.exam.check.service.ScoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Score")
@Api(description = "|教师端|学生成绩")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;


    /*@ApiOperation(value = "|Score|学生判卷",notes = "卷子id：paper_id</br>" +
            "student_answers:学生答案组 split by ','</br>" +
            "学生id:student_id</br>")
    @PostMapping(value = "/addQuestionnaire")
    public ResponseMessage addQuestionnaire(@RequestBody Answer answer){
        List error= checkService.check(answer);
        return Result.success(error);
    }*/


}
