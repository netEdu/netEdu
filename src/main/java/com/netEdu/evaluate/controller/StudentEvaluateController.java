package com.netEdu.evaluate.controller;

import com.adc.da.base.web.BaseController;
import com.adc.da.util.http.PageInfo;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.netEdu.entity.StudentEvaluate;
import com.netEdu.entity.VO.StudentEvaluateVO;
import com.netEdu.evaluate.page.StudentEvaluatePage;
import com.netEdu.evaluate.service.StudentEvaluateService;
import com.netEdu.lesson.rate.page.QuestionnairePage;
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
 * Date: 2018-05-04
 * Time: 20:28
 */
@RestController
@RequestMapping("/StudentEvaluate")
@Api(description = "学生自评")
public class StudentEvaluateController extends BaseController<StudentEvaluateVO> {
    @Autowired
    private StudentEvaluateService service;

    @ApiOperation(value = "|StudentEvaluate|添加学生自评",notes = "ideology：思想成绩</br>" +
            "study：学习热情</br>" +
            "morality:品德成绩"  )
    @PostMapping(value = "/addStudentEvaluate")
    public ResponseMessage<StudentEvaluate> addStudentEvaluate(@RequestBody StudentEvaluate studentEvaluate){
        service.add(studentEvaluate);
        return Result.success(studentEvaluate);
    }
    @ApiOperation(value = "|StudentEvaluate|查询学生个人评价",notes = "传入page页码，pageSize页容量,student_id：学生id"  )
    @PostMapping(value = "/SelectByStudentId")
    public ResponseMessage<PageInfo<StudentEvaluateVO>> SelectByStudentId(@RequestBody StudentEvaluatePage page){
        List<StudentEvaluateVO> rows = service.SelectByStudentId(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

    @ApiOperation(value = "|Paper|批量删除个人评价",notes = "ids：评论表ids")
    @PostMapping(value = "/deleteStudentEvaluate")
    public ResponseMessage delete(@RequestParam String ids){
        service.del(ids);
        return  Result.success();
    }
    @ApiOperation(value = "|Paper|修改个人评价",notes = "evaluate_id：评论表id</br>" +
            "student_id：学生id</br>" +
            "ideology：思想成绩</br>" +
            "study：学习热情</br>" +
            "morality:品德成绩")
    @PutMapping(value = "/updateStudentEvaluate")
    public ResponseMessage update(@RequestBody StudentEvaluate studentEvaluate){
        service.updateStudentEvaluate(studentEvaluate);
        return  Result.success();
    }





}
