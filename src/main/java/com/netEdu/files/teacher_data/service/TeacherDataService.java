package com.netEdu.files.teacher_data.service;

import com.netEdu.entity.Course;
import com.netEdu.entity.StudentData;
import com.netEdu.entity.TeacherData;

import java.util.List;

public interface TeacherDataService {

    List<Course> queryCourse(String teacher_id);

    void uploadOne(String data_title,int student_id,int course_id,String share,String savepathAndType);

    void uploadMany(String data_titles,int student_id,int course_id,String shares,String savepathsAndTypes);

    List<TeacherData> queryTeacherData(TeacherData teacherData);

    List<StudentData> queryStudentData(StudentData studentData);

    void delFiles(String data_ids);

}
