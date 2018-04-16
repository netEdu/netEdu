package com.netEdu.questionPool.question.controller;

import com.adc.da.base.web.BaseController;
import com.adc.da.util.http.PageInfo;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.netEdu.entity.Question;
import com.netEdu.entity.QuestionOption;
import com.netEdu.questionPool.question.service.QuestionService;
import com.netEdu.questionPool.question.vo.QuestionPage;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Question")
@Api(description = "|教师端|考题")
public class QuestionController extends BaseController<Question> {

    @Autowired
    private QuestionService questionService;

    @ApiOperation(value = "|Question|添加考题",notes = "teacher_id:出题教师id</br>" +
            "question_type:考题类型 0=判断 1=选择 2=主观</br>" +
            "question_content:考题内容</br>" +
            "question_answer(option_id):考题答案 A=0 B=1 C=2 D=3</br>" +
            "options:选项组 split by ','</br>" +
            "difficulty:考题难度")
    @PostMapping(value = "/addQuestion")
    public void addQuestion(@RequestBody Question question){
        questionService.add(question);
    }

    @ApiOperation(value = "|Question|编辑考题",notes = "teacher_id:出题教师id</br>" +
            "question_type:考题类型 0=判断 1=选择 2=主观</br>" +
            "question_content:考题内容</br>" +
            "question_answer(option_id):考题答案</br>" +
            "option_id:选项id</br>" +
            "option_content:选项内容</br>" +
            "difficulty:考题难度</br>" +
            "frequency:出题次数</br>" +
            "error_times:错误次数")
    @PutMapping(value = "/updateQuestion")
    public void update(@RequestBody Question question){
        questionService.update(question);
    }

    @ApiOperation(value = "|Question|批量删除考题",notes = "考题id组 split by ','")
    @DeleteMapping(value = "/deleteQuestion")
    public void delete(@RequestParam String ids){
        questionService.del(ids);
    }

    @ApiOperation(value = "|Question|查看单个考题")
    @GetMapping(value = "/queryQuestion")
    public Question queryOne(@RequestParam int id){
        return questionService.findOne(id);
    }

    @ApiOperation(value = "|Question|查看考题选项")
    @GetMapping(value = "/queryOptions")
    public List<QuestionOption> queryOpt(@RequestParam int id){
        return questionService.queryOptions(id);
    }

    @ApiOperation(value = "|Question|分页按条件查询考题",notes = "teacher_id:出题教师id</br>" +
            "question_type:考题类型 0=判断 1=选择 2=主观</br>" +
            "name:出题老师姓名 模糊</br>" +
            "question_content:考题内容 模糊</br>" +
            "difficulty:考题难度</br>" +
            "frequency:出题次数</br>" +
            "error_times:错误次数</br>" +
            "page:页码</br>" +
            "pageSize:页容量")
    @PostMapping(value = "/queryAllQuestion")
    public ResponseMessage<PageInfo<Question>> queryAll(@RequestBody QuestionPage questionPage){
        return Result.success(getPageInfo(questionPage.getPager(), questionService.findAllByCriteria(questionPage)));
    }

}
