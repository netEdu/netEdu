package com.netEdu.questionPool.question.controller;

import com.adc.da.base.web.BaseController;
import com.adc.da.util.http.PageInfo;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.netEdu.entity.Option;
import com.netEdu.entity.Question;
import com.netEdu.questionPool.question.service.QuestionService;
import com.netEdu.questionPool.question.service.impl.QuestionImpl;
import com.netEdu.questionPool.question.vo.QuestionPage;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("/Question")
@Api(description = "|教师端|考题")
public class QuestionController extends BaseController<Question> {

    @Autowired
    private QuestionService questionService;

    @ApiOperation(value = "|Question|添加考题")
    @PostMapping(value = "/addQuestion")
    public void addQuestion(@ApiParam(value = "出题教师id：teacher_id" +
            "考题类型 0：判断 1：选择 2：主观：question_content" +
            "考题内容：question_content" +
            "考题答案：question_answer" +
            "选项组：options" +
            "考题难度：difficulty") @RequestBody Question question){
        questionService.add(question);
    }

    @ApiOperation(value = "|Question|修改考题")
    @PutMapping(value = "/updateQuestion")
    public void update(@ApiParam("出题教师id:teacher_id" +
            "考题类型 0：判断 1：选择 2：主观:question_type" +
            "考题内容:question_content" +
            "考题答案:question_answer" +
            "考题难度:difficulty" +
            "出题次数:frequency" +
            "错误次数:error_times") @RequestBody Question question){
        questionService.update(question);
    }

    @ApiOperation(value = "|Question|批量删除考题")
    @DeleteMapping(value = "/deleteQuestion")
    public void delete(@RequestParam String ids){
        questionService.del(ids);
    }

    @ApiOperation(value = "|Question|查看单个考题")
    @GetMapping(value = "/queryQuestion")
    public Question queryOne(@RequestParam int id){
        return questionService.findOne(id);
    }

    @ApiOperation(value = "|Question|分页按条件查询考题")
    @PostMapping(value = "/queryAllQuestion")
    public ResponseMessage<PageInfo<Question>> queryAll(@ApiParam("出题教师id:teacher_id" +
            "考题类型 0：判断 1：选择 2：主观:question_type" +
            "考题内容 模糊:question_content" +
            "考题难度:difficulty" +
            "出题次数:frequency" +
            "错误次数:error_times" +
            "页码:page" +
            "页容量:pageSize") @RequestBody QuestionPage questionPage){
        return Result.success(getPageInfo(questionPage.getPager(), questionService.findAllByCriteria(questionPage)));
    }

}
