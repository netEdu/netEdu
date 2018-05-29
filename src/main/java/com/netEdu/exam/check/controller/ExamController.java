package com.netEdu.exam.check.controller;

import com.adc.da.util.http.PageInfo;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.netEdu.entity.Paper;
import com.netEdu.entity.Question;
import com.netEdu.exam.check.service.ExamService;
import com.netEdu.paper.vo.PaperPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author LZZ
 * Created by LZZ on 2018/5/29.
 */
@RestController
@RequestMapping("/Exam")
@Api(description = "|学生端|考试")
public class ExamController {

    @Autowired
    private ExamService examService;

    @ApiOperation(value = "|Paper|查看试卷",notes = "rua！")
    @GetMapping(value = "/showExam")
    public List<Question> queryOne(@RequestParam int id){
        return examService.queryOnePaper(id);
    }

}
