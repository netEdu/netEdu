package com.netEdu.files.student_data.service.impl;

import com.netEdu.entity.StudentData;
import com.netEdu.files.student_data.dao.StudentDataMapper;
import com.netEdu.files.student_data.service.StudentDataService;
import com.netEdu.utils.File.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StudentDataImpl implements StudentDataService{

    @Autowired
    private StudentDataMapper studentDataMapper;

    @Override
    public void uploadOne(String data_title, int student_id, int course_id,String savepathAndType) {
        StudentData studentData = new StudentData();
        studentData.setData_title(data_title);
        studentData.setStudent_id(student_id);
        studentData.setCourse_id(course_id);
        String[] str = savepathAndType.split(",");
        studentData.setData_type(str[1].toString());
        Date date=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //当前时间 df.format(date)
        studentData.setUpload_time(df.format(date));
        studentData.setSavepath(str[0].toString());
        studentDataMapper.insertSelective(studentData);
    }

    @Override
    public void uploadMany(String data_titles, int student_id, int course_id, String savepathsAndTypes) {
        String[] title = data_titles.split(",");
        String[] str = savepathsAndTypes.split("[?]");
        String[] types = str[1].split(",");
        String[] paths = str[0].split(",");
        for (int i = 0;i < title.length;i ++){
            StudentData studentData = new StudentData();
            studentData.setStudent_id(student_id);
            studentData.setCourse_id(course_id);
            Date date=new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //当前时间 df.format(date)
            studentData.setUpload_time(df.format(date));
            studentData.setData_title(title[i].toString());
            studentData.setData_type(types[i].toString());
            studentData.setSavepath(paths[i].toString());
            studentDataMapper.insertSelective(studentData);
        }
    }

    @Override
    public List<StudentData> queryData(StudentData studentData) {
        return null;
    }

}
