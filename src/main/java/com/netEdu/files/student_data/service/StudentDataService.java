package com.netEdu.files.student_data.service;

import com.netEdu.entity.StudentData;

import java.util.List;

public interface StudentDataService {

    void uploadOne(String data_title,int student_id,int course_id,String savepathAndType);

    void uploadMany(String data_titles,int student_id,int course_id,String data_types,String savepaths);

    List<StudentData> queryData(StudentData studentData);

}
