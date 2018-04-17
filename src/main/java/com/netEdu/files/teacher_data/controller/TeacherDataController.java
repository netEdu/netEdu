package com.netEdu.files.teacher_data.controller;

import com.netEdu.files.teacher_data.service.TeacherDataService;
import com.netEdu.utils.File.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/TeacherData")
@Api(description = "|教师端|资料")
public class TeacherDataController {

    @Autowired
    private TeacherDataService teacherDataService;

    @ApiOperation(value = "|TeacherData|添加资料",notes = "data_title:资料标题</br>" +
            "student_id:上传教师id</br>" +
            "course_id:课程id</br>" +
            "share:是否共享 0:共享 1:私密")
    @PostMapping(value = "/uploadOne")
    public void add(@RequestParam MultipartFile file,
                    @RequestParam String data_title,
                    @RequestParam int teacher_id,
                    @RequestParam int course_id,
                    @RequestParam String share) {
        teacherDataService.uploadOne(data_title,teacher_id,course_id,share,FileUtil.uploadOne(file));
    }

    /**
     * 文件批量上传
     * */
    @ApiOperation(value = "|TeacherData|批量添加资料",notes = "data_titles:资料标题 split by ','</br>" +
            "student_id:上传教师id</br>" +
            "course_id:课程id</br>" +
            "shares:是否共享 0:共享 1:私密 split by ','")
    @PostMapping(value = "/uploadMany")
    public void addFiles(@ApiParam(value = "key = files") HttpServletRequest request,
                         @RequestParam String data_titles,
                         @RequestParam int teacher_id,
                         @RequestParam int course_id,
                         @RequestParam String shares) {
        teacherDataService.uploadMany(data_titles,teacher_id,course_id,shares,FileUtil.uploadMany(request));
    }

}
