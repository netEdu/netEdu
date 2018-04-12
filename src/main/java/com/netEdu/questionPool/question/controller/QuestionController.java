package com.netEdu.questionPool.question.controller;

import com.adc.da.base.web.BaseController;
import com.adc.da.util.http.PageInfo;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.netEdu.entity.Option;
import com.netEdu.entity.Question;
import com.netEdu.questionPool.question.service.impl.QuestionImpl;
import com.netEdu.questionPool.question.vo.QuestionPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("/Question")
@Api(description = "|教师端|考题")
public class QuestionController extends BaseController<Question> {

    @Autowired
    private QuestionImpl questionImpl;

    @ApiOperation(value = "|Question|添加考题")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "teacher_id", value = "出题教师id", required = true, dataType = "int"),
            @ApiImplicitParam(name = "question_type", value = "考题类型 0：判断 1：选择 2：主观", required = true, dataType = "varchar"),
            @ApiImplicitParam(name = "question_content", value = "考题内容", required = true, dataType = "varchar"),
            @ApiImplicitParam(name = "question_answer", value = "考题答案", required = true, dataType = "varchar"),
            @ApiImplicitParam(name = "difficulty", value = "考题难度", required = true, dataType = "varchar")
    })
    @PostMapping(value = "/addQuestion")
    public void addQuestion(@RequestBody Question question){
        questionImpl.add(question);
    }

    @ApiOperation(value = "|Question|添加选项")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "question_id", value = "考题id", required = true, dataType = "int"),
            @ApiImplicitParam(name = "option_content", value = "选项内容", required = true, dataType = "varchar")
    })
    @PostMapping(value = "/addOption")
    public void addOption(@RequestBody Option option){

        questionImpl.addOption(option);
    }

    @ApiOperation(value = "|Question|修改考题")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "teacher_id", value = "出题教师id", required = true, dataType = "int"),
            @ApiImplicitParam(name = "question_type", value = "考题类型 0：判断 1：选择 2：主观", required = true, dataType = "varchar"),
            @ApiImplicitParam(name = "question_content", value = "考题内容", required = true, dataType = "varchar"),
            @ApiImplicitParam(name = "question_answer", value = "考题答案", required = true, dataType = "varchar"),
            @ApiImplicitParam(name = "difficulty", value = "考题难度", required = true, dataType = "varchar"),
            @ApiImplicitParam(name = "frequency", value = "出题次数", required = false, dataType = "int"),
            @ApiImplicitParam(name = "error_times", value = "错误次数", required = false, dataType = "int")
    })
    @PutMapping(value = "/updateQuestion")
    public void update(@RequestBody Question question){
        questionImpl.update(question);
    }

    @ApiOperation(value = "|Question|批量删除考题")
    @DeleteMapping(value = "/deleteQuestion")
    public void delete(@RequestParam String ids){
        questionImpl.del(ids);
    }

    @ApiOperation(value = "|Question|查看单个考题")
    @GetMapping(value = "/queryQuestion")
    public Question queryOne(@RequestParam int id){
        return questionImpl.findOne(id);
    }

    @ApiOperation(value = "|Question|分页按条件查询考题")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "teacher_id", value = "出题教师id", required = true, dataType = "int"),
            @ApiImplicitParam(name = "question_type", value = "考题类型 0：判断 1：选择 2：主观", required = true, dataType = "varchar"),
            @ApiImplicitParam(name = "question_content", value = "考题内容 模糊", required = true, dataType = "varchar"),
            @ApiImplicitParam(name = "difficulty", value = "考题难度", required = true, dataType = "varchar"),
            @ApiImplicitParam(name = "frequency", value = "出题次数", required = false, dataType = "int"),
            @ApiImplicitParam(name = "error_times", value = "错误次数", required = false, dataType = "int"),
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "页容量", required = true, dataType = "int")
    })
    @PostMapping(value = "/queryAllQuestion")
    public ResponseMessage<PageInfo<Question>> queryAll(@RequestBody @ApiIgnore QuestionPage questionPage){
        return Result.success(getPageInfo(questionPage.getPager(), questionImpl.findAllByCriteria(questionPage)));
    }

}
