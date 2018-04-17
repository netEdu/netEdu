package com.netEdu.files.student_data.controller;

import com.netEdu.entity.StudentData;
import com.netEdu.files.student_data.service.StudentDataService;
import com.netEdu.utils.File.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/StudentData")
@Api(description = "|学生端|资料")
public class StudentDataController {

    @Autowired
    private StudentDataService studentDataService;

    @ApiOperation(value = "|StudentData|添加资料",notes = "data_title:资料标题</br>" +
            "student_id:上传学生id</br>" +
            "course_id:课程id")
    @PostMapping(value = "/uploadOne")
    public void add(@RequestParam MultipartFile file,
                      @RequestParam String data_title,
                      @RequestParam int student_id,
                      @RequestParam int course_id) {
        studentDataService.uploadOne(data_title,student_id,course_id,FileUtil.uploadOne(file));
    }

    /**
     * 文件批量上传
     * */
    @ApiOperation(value = "|StudentData|批量添加资料",notes = "data_titles:资料标题 split by ','</br>" +
            "student_id:上传学生id</br>" +
            "course_id:课程id")
    @PostMapping(value = "/uploadMany")
    public void addFiles(@ApiParam(value = "key = files") HttpServletRequest request,
                                  @RequestParam String data_titles,
                                  @RequestParam int student_id,
                                  @RequestParam int course_id,
                                  @RequestParam String data_types) {
        studentDataService.uploadMany(data_titles,student_id,course_id,data_types,FileUtil.uploadMany(request));
    }

    @PostMapping(value = "/queryStudentData")
    public List<StudentData> query(@RequestBody StudentData studentData){
        return studentDataService.queryData(studentData);
    }

    @DeleteMapping(value = "/deleteFiles")
    public void del(){

    }

}
