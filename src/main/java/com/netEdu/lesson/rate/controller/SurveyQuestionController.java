package com.netEdu.lesson.rate.controller;

import com.adc.da.base.web.BaseController;
import com.adc.da.util.http.PageInfo;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.netEdu.entity.Questionnaire;
import com.netEdu.entity.SurveyQuestion;
import com.netEdu.lesson.rate.page.SurveyQuestionPage;
import com.netEdu.lesson.rate.service.SurveyQuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Lei
 * Date: 2018-04-17
 * Time: 9:44
 */
@RestController
@RequestMapping("/SurveyQuestion")
@Api(description = "|管理员端|问卷问题")
public class SurveyQuestionController extends BaseController<SurveyQuestion> {
    @Autowired
    private SurveyQuestionService surveyQuestionService;

    @ApiOperation(value = "|SurveyQuestion||SurveyQuestion|添加教师问卷问题",notes = "创建者：creator</br>" +
            "survey_content:问题内容</br>" +
            "survey_type:问题类型（0：单选，1：简答）</br>")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE,value = "/addSurveyQuestion")
    public ResponseMessage<SurveyQuestion> addSurveyQuestion(@RequestBody SurveyQuestion surveyQuestion){
        surveyQuestionService.addSurveyQuestion(surveyQuestion);
        return Result.success(surveyQuestion);
    }
    @ApiOperation(value = "|SurveyQuestion|删除教师问卷问题",notes = "question_ids:问题id组使用逗号分隔")
    @DeleteMapping(value = "delSurveyQuestion")
    public ResponseMessage delSurveyQuestion(@RequestParam String question_ids){
        surveyQuestionService.delSurveyQuestion(question_ids);
        return Result.success();
    }

    @ApiOperation(value = "|SurveyQuestion|分页查询教师问卷问题",notes = "page:页码</br>" +
            "pageSize:页容量")
    @PostMapping(value = "/selectBypage")
    public ResponseMessage<PageInfo<SurveyQuestion>>selectBypage(@ApiParam(value = "传入page页码，pageSize页容量" ,required=false )@RequestBody SurveyQuestionPage page){
        List<SurveyQuestion> rows = surveyQuestionService.selectBypage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

    @ApiOperation(value = "|SurveyQuestion|修改教师问卷问题",notes = "question_id:要修改的主键" +
            "创建者（修改人）：creator</br>" +
            "survey_content:问题内容</br>" +
            "survey_type:问题类型（0：单选，1：简答）</br>")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE,value = "/upSurveyQuestion")
    public ResponseMessage upSurveyQuestion(@RequestBody SurveyQuestion surveyQuestion){
        surveyQuestionService.upSurveyQuestion(surveyQuestion);
        return Result.success();
    }
    @ApiOperation(value = "|SurveyQuestion|查询单个教师问卷问题详情",notes = "question_id:问卷问题id")
    @PostMapping(value = "/selectByQuestionid")
    public ResponseMessage<SurveyQuestion> selectByQuestionnaireId(@RequestParam int question_id){
        return Result.success(surveyQuestionService.selectByQuestionid(question_id));
    }

}
