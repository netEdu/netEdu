package com.netEdu.lesson.rate.controller;

import com.adc.da.base.web.BaseController;
import com.adc.da.util.http.PageInfo;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.netEdu.entity.Questionnaire;
import com.netEdu.lesson.rate.page.QuestionnairePage;
import com.netEdu.lesson.rate.service.QuestionnaireService;
import com.netEdu.lesson.rate.service.impl.QuestionnaireImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Lei
 * Date: 2018-04-13
 * Time: 16:28
 */
@RestController
@RequestMapping("/Questionnaire")
@Api(description = "|教师端|教师评价问卷")
public class QuestionnaireController extends BaseController<Questionnaire> {

    @Autowired
    private QuestionnaireService questionnaireService;

    @ApiOperation(value = "|Questionnaire|添加教师问卷",notes = "创建者：creator</br>" +
            "survey_questions:问题id组 split by ','</br>" +
            "create_time:创建时间</br>" +
            "remarks:说明</br>" +
            "teacher_id:教师id/br>" )
    @PostMapping(value = "/addQuestionnaire")
    public ResponseMessage<Questionnaire> addQuestionnaire(@RequestBody Questionnaire questionnaire){
        questionnaireService.add(questionnaire);
        return Result.success(questionnaire);
    }
    @ApiOperation(value = "|Questionnaire|修改",notes ="questionnaire_id:问卷主键</br>" +
            "survey_questions:问题id组 split by ','</br>" +
            "create_time:创建时间</br>" +
            "remarks:说明</br>" +
            "teacher_id:教师id</br>" )
    @PostMapping(value = "/upQuestionnaire")
    public void upQuestionnaire(@RequestBody Questionnaire questionnaire){
        questionnaireService.upQuestionnaire(questionnaire);
    }

    @ApiOperation(value = "|Questionnaire|批量删除教师问卷",notes = "问卷id组 split by ','")
    @DeleteMapping(value = "/deleteQuestionnaire")
    public ResponseMessage deleteQuestionnaire(@RequestParam String ids){
        questionnaireService.deleteQuestionnaire(ids);
        return Result.success();
    }
    @ApiOperation(value = "|Questionnaire|分页查询教师问卷",notes = "page:页码</br>"+"pageSize:页容量")
    @PostMapping(value = "/pageQuestionnaire")
    public ResponseMessage<PageInfo<Questionnaire>> pageQuestionnaire(@ApiParam(value = "传入page页码，pageSize页容量" ,required=false )@RequestBody QuestionnairePage page){

        List<Questionnaire> rows = questionnaireService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }
    @ApiOperation(value = "|Questionnaire|查询单个教师问卷详情",notes = "questionnaire_id:问卷id")
    @PostMapping(value = "/selectByQuestionnaireId")
    public ResponseMessage<Questionnaire> selectByQuestionnaireId(@RequestParam int questionnaire_id){
        return Result.success(questionnaireService.selectByQuestionnaireId(questionnaire_id));
    }





}
