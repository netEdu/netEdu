package com.netEdu.paper.controller;

import com.adc.da.base.web.BaseController;
import com.adc.da.util.http.PageInfo;
import com.adc.da.util.http.ResponseMessage;
import com.adc.da.util.http.Result;
import com.netEdu.entity.Paper;
import com.netEdu.entity.Question;
import com.netEdu.paper.service.PaperService;
import com.netEdu.paper.vo.PaperPage;
import com.netEdu.questionPool.question.vo.QuestionPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Paper")
@Api(description = "|教师端|试卷")
public class PaperController extends BaseController<Paper> {

    @Autowired
    private PaperService paperService;

    @ApiOperation(value = "|Paper|添加试卷",notes = "teacher_id:教师id</br>" +
            "paper_name:试卷标题</br>" +
            "questions(question_id):试卷题目组 split by ','</br>" +
            "remarks:试卷备注")
    @PostMapping(value = "/addPaper")
    public void addPaper(@RequestBody Paper paper){
        paperService.add(paper);
    }

    @ApiOperation(value = "|Paper|查看试卷列表",notes = "name:教师姓名 模糊</br>" +
            "paper_name:试卷标题 模糊</br>" +
            "remarks:试卷备注 模糊</br>" +
            "startDate:起始时间 YYYY-MM-DD</br>" +
            "endDate:终止时间 YYYY-MM-DD")
    @PostMapping(value = "/showPaperList")
    public ResponseMessage<PageInfo<Paper>> queryAll(@RequestBody PaperPage paperPage){
        return Result.success(getPageInfo(paperPage.getPager(), paperService.queryPaperListByCriteria(paperPage)));
    }

    @ApiOperation(value = "|Paper|查看试卷",notes = "")
    @GetMapping(value = "/showPaper")
    public List<Question> queryOne(@RequestParam int id){
        return paperService.queryOnePaper(id);
    }

    @ApiOperation(value = "|Paper|批量删除试卷",notes = "")
    @DeleteMapping(value = "/deletePaper")
    public void delete(@RequestParam String ids){
        paperService.del(ids);
    }

    @ApiOperation(value = "|Paper|修改试卷信息",notes = "paper_id:试卷id</br>" +
            "paper_name:试卷标题</br>" +
            "questions(question_id):试卷题目组 split by ','</br>" +
            "remarks:试卷备注")
    @PutMapping(value = "/updatePaper")
    public void update(@RequestBody Paper paper){
        paperService.updatePaper(paper);
    }

}
