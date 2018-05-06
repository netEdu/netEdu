package com.netEdu.evaluate.controller;

import com.adc.da.base.web.BaseController;
import com.adc.da.util.http.PageInfo;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.netEdu.entity.MEvaluate;
import com.netEdu.entity.StudentEvaluate;
import com.netEdu.entity.VO.MEvaluateVO;
import com.netEdu.entity.VO.StudentEvaluateVO;
import com.netEdu.evaluate.page.MEvaluatePage;
import com.netEdu.evaluate.page.StudentEvaluatePage;
import com.netEdu.evaluate.service.MEvaluateService;
import com.netEdu.evaluate.service.StudentEvaluateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/MEvaluate")
@Api(description = "学生互评")
public class MEvaluateController extends BaseController<MEvaluateVO> {
    @Autowired
    private MEvaluateService service;

    @ApiOperation(value = "|MEvaluate|添加学生互评",notes = "student_id：被评价学生id</br>" +
            "ideology：思想成绩</br>" +
            "study：学习热情</br>" +
            "morality:品德成绩"  )
    @PostMapping(value = "/addMEvaluate")
    public ResponseMessage<MEvaluate> addMEvaluate(@RequestBody MEvaluate mEvaluate){
        service.add(mEvaluate);
        return Result.success(mEvaluate);
    }
    @ApiOperation(value = "|MEvaluate|查询学生所有评价",notes = "传入page页码，pageSize页容量,student_id：学生id"  )
    @PostMapping(value = "/SelectByStudentId")
    public ResponseMessage<PageInfo<MEvaluateVO>> SelectByStudentId(@RequestBody MEvaluatePage page){
        List<MEvaluateVO> rows = service.SelectByStudentId(page);
        return Result.success(getPageInfo(page.getPager(), rows));
    }

    @ApiOperation(value = "|MEvaluate|批量删除此人所有相关评价",notes = "student_id：学生id")
    @PostMapping(value = "/deleteStudentEvaluate")
    public ResponseMessage delete(@RequestParam String student_id){
        service.del(student_id);
        return  Result.success();
    }

}
