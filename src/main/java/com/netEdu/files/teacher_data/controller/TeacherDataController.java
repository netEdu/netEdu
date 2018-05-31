package com.netEdu.files.teacher_data.controller;

import com.netEdu.entity.Course;
import com.netEdu.entity.StudentData;
import com.netEdu.entity.TeacherData;
import com.netEdu.files.student_data.service.StudentDataService;
import com.netEdu.files.teacher_data.service.TeacherDataService;
import com.netEdu.utils.File.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/TeacherData")
@Api(description = "|教师端|资料")
public class TeacherDataController {

    @Autowired
    private TeacherDataService teacherDataService;

    @Autowired
    private StudentDataService studentDataService;

    @ApiOperation(value = "|TeacherData|查看可用课程",notes = "teacher_id:教师id")
    @PostMapping(value = "/queryCourse")
    public List<Course> query(String teacher_id){
        return teacherDataService.queryCourse(teacher_id);
    }

    @ApiOperation(value = "|TeacherData|添加资料",notes = "data_title:资料标题</br>" +
            "student_id:上传教师id</br>" +
            "course_id:课程id</br>" +
            "share:是否共享 0:共享 1:私密")
    @PostMapping(value = "/uploadOne")
    public String add(@RequestParam MultipartFile file,
                    @RequestParam String data_title,
                    @RequestParam int teacher_id,
                    @RequestParam int course_id,
                    @RequestParam String share) {
        return teacherDataService.uploadOne(data_title,teacher_id,course_id,share,FileUtil.uploadOne(file));
    }

    /**
     * 文件批量上传
     * */
    @ApiOperation(value = "|TeacherData|批量添加资料",notes = "data_titles:资料标题 split by ','</br>" +
            "student_id:上传教师id</br>" +
            "course_id:课程id</br>" +
            "shares:是否共享 0:共享 1:私密 split by ','")
    @PostMapping(value = "/uploadMany")
    public String addFiles(@ApiParam(value = "key = files") HttpServletRequest request,
                         @RequestParam String data_titles,
                         @RequestParam int teacher_id,
                         @RequestParam int course_id,
                         @RequestParam String shares) {
        return teacherDataService.uploadMany(data_titles,teacher_id,course_id,shares,FileUtil.uploadMany(request));
    }

    @ApiOperation(value = "|TeacherData|查看个人资料",notes = "teacher_id:教师id</br>" +
            "data_title:资料标题 模糊</br>" +
            "course_name:课程名 模糊</br>" +
            "course_id:课程id</br>" +
            "data_type:资料类型")
    @PostMapping(value = "/queryTeacherData")
    public List<TeacherData> Teacher(@RequestBody TeacherData teacherData){
        return teacherDataService.queryTeacherData(teacherData);
    }

    @ApiOperation(value = "|TeacherData|查看学生资料",notes = "name:学生姓名 模糊</br>" +
            "data_title:资料标题 模糊</br>" +
            "course_name:课程名 模糊</br>" +
            "course_id:课程id</br>" +
            "data_type:资料类型</br>" +
            "class_num:班号")
    @PostMapping(value = "/queryStudentData")
    public List<StudentData> queryStudent(@RequestBody StudentData studentData){
        return teacherDataService.queryStudentData(studentData);
    }

    @ApiOperation(value = "|TeacherData|删除个人资料",notes = "data_ids:资料id组 split by ','")
    @DeleteMapping(value = "/deleteFiles")
    public void del(@RequestParam String data_ids){
        teacherDataService.delFiles(data_ids);
    }

    @ApiOperation(value = "|TeacherData|下载资料",notes = "data_id:资料id")
    @GetMapping(value = "/downloadFile")
    public void dl(HttpServletResponse response,@RequestParam String data_id){
        try {
            FileUtil.download(response,teacherDataService.downloadFile(data_id));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ApiOperation(value = "|TeacherData|给学生成果打分",notes = "data_id:资料id<br>" +
            "score:资料成绩")
    @PostMapping(value = "/markData")
    public void mark(@RequestBody StudentData studentData){
        studentDataService.markData(studentData);
    }

}
