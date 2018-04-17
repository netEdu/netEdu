package com.netEdu.files.student_data.service;

import com.netEdu.entity.StudentData;

import java.util.List;

public interface StudentDataService {

    void uploadOne(String data_title,int teacher_id,int course_id,String savepathAndType);

    void uploadMany(String data_titles,int teacher_id,int course_id,String savepathsAndTypes);

    List<StudentData> queryData(StudentData studentData);

}
