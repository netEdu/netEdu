package com.netEdu.exam.check.controller;

import com.adc.da.base.web.BaseController;
import com.adc.da.util.http.PageInfo;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.netEdu.entity.Answer;
import com.netEdu.entity.Score;
import com.netEdu.entity.Student;
import com.netEdu.entity.VO.ScoreVO;
import com.netEdu.exam.check.page.ScorePage;
import com.netEdu.exam.check.service.CheckService;
import com.netEdu.exam.check.service.ScoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("/Score")
@Api(description = "|教师端|学生成绩")
public class ScoreController extends BaseController<ScoreVO>{

    @Autowired
    private ScoreService scoreService;

    //分页查询所有学生的分数
    @ApiOperation(value = "|Score|所有学生分数列表",notes = "page:页码</br>"+"pageSize:页容量")
    @PostMapping(value = "/selectStudentScore")
    public ResponseMessage<PageInfo<ScoreVO>> pageQuestionnaire(@ApiParam(value = "传入page页码，pageSize页容量" ,required=false )@RequestBody ScorePage page){
        List<ScoreVO> rows = scoreService.queryByPage(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

    //查询单个学生所有成绩
    @ApiOperation(value = "|Score|单个学生分数列表",notes = "page:页码</br>"+"pageSize:页容量,student_id学生id")
    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE,value = "/selectScoreByStudentId")
    public ResponseMessage<PageInfo<ScoreVO>> selectScoreByStudentId(@ApiParam(value = "传入page页码，pageSize页容量,student_id学生id" ,required=false )@RequestBody ScorePage page){
        List<ScoreVO> rows = scoreService.selectScoreByStudentId(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

    //查询单人各项平均成绩
    @ApiOperation(value = "|Score|查询单个学生各项平均成绩（卷子+考勤+小测+成果）",notes = "questionnaire_id:问卷id")
    @PostMapping(value = "/AVGStudentId")
    public ResponseMessage<ScoreVO> AVGStudentId(@RequestParam int student_id){
        return Result.success(scoreService.AVGStudentId(student_id));
    }

}
