package com.netEdu.files.teacher_data.service.impl;

import com.netEdu.entity.StudentData;
import com.netEdu.entity.TeacherData;
import com.netEdu.files.teacher_data.dao.TeacherDataMapper;
import com.netEdu.files.teacher_data.service.TeacherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TeacherDataImpl implements TeacherDataService {

    @Autowired
    private TeacherDataMapper teacherDataMapper;

    @Override
    public void uploadOne(String data_title, int teacher_id, int course_id, String share, String savepathAndType) {
        TeacherData teacherData = new TeacherData();
        teacherData.setData_title(data_title);
        teacherData.setTeacher_id(teacher_id);
        teacherData.setCourse_id(course_id);
        teacherData.setShare(share);
        String[] str = savepathAndType.split(",");
        teacherData.setData_type(str[1].toString());
        Date date=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //当前时间 df.format(date)
        teacherData.setUpload_time(df.format(date));
        teacherData.setSavepath(str[0].toString());
        teacherDataMapper.insertSelective(teacherData);
    }

    @Override
    public void uploadMany(String data_titles, int teacher_id, int course_id, String shares, String savepathsAndTypes) {
        String[] title = data_titles.split(",");
        String[] str = savepathsAndTypes.split("[?]");
        String[] types = str[1].split(",");
        String[] paths = str[0].split(",");
        String[] share = shares.split(",");
        for (int i = 0;i < title.length;i ++){
            TeacherData teacherData = new TeacherData();
            teacherData.setTeacher_id(teacher_id);
            teacherData.setCourse_id(course_id);
            Date date=new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //当前时间 df.format(date)
            teacherData.setUpload_time(df.format(date));
            teacherData.setData_title(title[i].toString());
            teacherData.setData_type(types[i].toString());
            teacherData.setSavepath(paths[i].toString());
            teacherData.setShare(share[i].toString());
            teacherDataMapper.insertSelective(teacherData);
        }
    }

}
