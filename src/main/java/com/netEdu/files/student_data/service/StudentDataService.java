package com.netEdu.files.student_data.service;

import com.netEdu.entity.Course;
import com.netEdu.entity.StudentData;
import com.netEdu.entity.TeacherData;

import java.util.List;

public interface StudentDataService {

    List<Course> queryCourse(String student_id);

    void uploadOne(String data_title,int teacher_id,int course_id,String savepathAndType);

    void uploadMany(String data_titles,int teacher_id,int course_id,String savepathsAndTypes);

    List<StudentData> queryStudentData(StudentData studentData);

    List<TeacherData> queryTeacherData(TeacherData teacherData);

    void delFiles(String data_ids);

    String downloadFile(String data_id);

}
