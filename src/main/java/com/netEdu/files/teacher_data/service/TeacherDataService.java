package com.netEdu.files.teacher_data.service;

public interface TeacherDataService {

    void uploadOne(String data_title,int student_id,int course_id,String share,String savepathAndType);

    void uploadMany(String data_titles,int student_id,int course_id,String shares,String savepathsAndTypes);

}
